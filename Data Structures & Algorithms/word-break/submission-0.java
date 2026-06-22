class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      Boolean[] dp =new Boolean[s.length()+1];
      Set<String> dict=new HashSet<>(wordDict);

      return check(s,0,dict,dp);
        
    }

    public boolean check(String s,int start,Set<String> wordDict,Boolean[] dp){

        if(start==s.length()) return true;

        if(dp[start]!=null) return dp[start];

        for(int i=start;i<s.length();i++){
           if(wordDict.contains(s.substring(start,i+1))){
            if(check(s,i+1,wordDict,dp)==true) return dp[i+1]=true;
           }
        }

        return dp[start]=false;

    }
}


