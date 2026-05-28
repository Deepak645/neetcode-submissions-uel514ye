class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);

          return solve(0,s,dp);
        
    }

    public int solve(int i,String s,int[] dp){

        if(i==s.length()) return 1;

        if(s.charAt(i)=='0') return dp[i]=0;

        if(dp[i]!=-1) return dp[i];

        int single=solve(i+1,s,dp);
        int dual=0;
      
        if(i+1<s.length()){
         
          int num=Integer.parseInt(s.substring(i,i+2));
           if(num<=26 && num>=10){
            dual=solve(i+2,s,dp);
          } 

        }

        return dp[i]=single+dual;
    
}
}
