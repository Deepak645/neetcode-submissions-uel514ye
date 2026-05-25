class Solution {
    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        
        Arrays.fill(dp,-1);
        int choose=solve(0,nums,nums.length-1,dp);
        Arrays.fill(dp,-1);
        int skip=solve(1,nums,nums.length,dp);

        return Math.max(choose,skip);
        
    }

    public int solve(int i,int[] nums,int end,int[] dp){

        if(i>=end) return 0;

        if(dp[i]!=-1) return dp[i];

        int rob=nums[i]+solve(i+2,nums,end,dp);
        int skip=solve(i+1,nums,end,dp);

        return dp[i]=Math.max(rob,skip);
        
    }
}
