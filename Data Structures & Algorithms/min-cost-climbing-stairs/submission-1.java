class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int[] dp=new int[cost.length];
       Arrays.fill(dp,-1);
       return Math.min(solve(cost,cost.length-1,dp),solve(cost,cost.length-2,dp));
      
    }

    public int solve(int[] cost,int ind,int[] dp){
 
       if(ind==0) return dp[0]=cost[0];
       if(ind==1) return dp[1]=cost[1];

       if(dp[ind]!=-1) return dp[ind];
       
       return dp[ind]=cost[ind]+Math.min(solve(cost,ind-1,dp),solve(cost,ind-2,dp));
    }
}


