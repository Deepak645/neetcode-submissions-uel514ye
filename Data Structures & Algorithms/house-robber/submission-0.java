class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        solve(0,nums,dp);

        return dp[0];
    }

    public int solve(int i,int[] nums,int[] dp){

        if(i>=nums.length) return 0;
        
        if(dp[i]!=-1) return dp[i];

        int skip=solve(i+1,nums,dp);
        int rob= nums[i]+solve(i+2,nums,dp);

        return dp[i]=Math.max(skip,rob);
    }


}
