class Solution {
    int[] dp;
    public int climbStairs(int n) {
      
       dp=new int[n+1];
       Arrays.fill(dp,-1);
       dp[0]=0;
       helper(n);
       return dp[n];
    }

    public int helper(int n){
       
        
        if(n==1) return dp[1]=1;
        if(n==2) return dp[2]=2;

        if(dp[n]!=-1) return dp[n];


        return dp[n]=helper(n-1)+helper(n-2);
    }
}


