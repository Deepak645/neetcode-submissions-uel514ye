class Solution {
    public int lengthOfLIS(int[] nums) {

        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return count(nums,0,-1,dp);
    }

    public int count(int[] nums,int ind,int prevInd,int[][] dp){

        if(ind==nums.length) return 0;

        if(dp[ind][prevInd+1]!=-1) return dp[ind][prevInd+1];

        int skip=count(nums,ind+1,prevInd,dp);

        int pick=0;

        if(prevInd==-1 || nums[ind]>nums[prevInd]){
            pick=1+count(nums,ind+1,ind,dp);
        }

        return dp[ind][prevInd+1]=Math.max(skip,pick);
    }
}
