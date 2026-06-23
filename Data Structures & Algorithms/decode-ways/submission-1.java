class Solution {
    public int numDecodings(String s) {

    int[] dp=new int[s.length()];
    Arrays.fill(dp,-1);
    return count(s,0,dp);
        
    }

    public int count(String s,int ind,int[] dp){
      if(ind==s.length()) return 1;

      if(s.charAt(ind)=='0') return 0;

      if(dp[ind]!=-1) return dp[ind];

      int ind1=0;
      int ind2=0;

      int single=Integer.parseInt(s.substring(ind,ind+1));
      
      if(single>=1 && single<=26) {
        ind1= count(s,ind+1,dp);
      }
       if(ind!=s.length()-1){

          int dual=Integer.parseInt(s.substring(ind,ind+2));
          if(dual>=1 && dual<=26){
            ind2=count(s,ind+2,dp);
         }
      }

     

      return dp[ind]=ind1+ind2;

    }
}
