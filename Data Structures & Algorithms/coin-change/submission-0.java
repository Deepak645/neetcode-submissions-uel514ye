class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans=check(coins,0,amount,dp);

        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public int check(int[] coins,int ind,int amount,int[][] dp){

        if(amount==0) return 0;

        if(ind==coins.length || amount<0) return Integer.MAX_VALUE;

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int pick=check(coins,ind,amount-coins[ind],dp);
        if(pick!=Integer.MAX_VALUE){
            pick+=1;
        }

        int skip=check(coins,ind+1,amount,dp);

        return dp[ind][amount]=Math.min(pick,skip);
    }
}
