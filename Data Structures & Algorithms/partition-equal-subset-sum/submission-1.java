class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;

         for(int num:nums){
            sum+=num;
        }

        Boolean[][] dp=new Boolean[nums.length][sum/2+1];       

        if(sum%2==1) return false;

        return check(nums,sum/2,0,dp);
        
    }

    public boolean check(int[] nums,int target,int ind,Boolean[][] dp){

        if(target==0) return true;

        if(target<0 || ind>=nums.length){
            return false;
        }

        if(dp[ind][target]!=null) return dp[ind][target];

        return dp[ind][target]=check(nums,target-nums[ind],ind+1,dp) || check(nums,target,ind+1,dp);
    }


}

/* 
What my function should return:
f(i,target)= From index i is target possible

choice= pick up or not pick up

recurrence relation: f(i,target)= f(i+1,target-nums[i]) or f(i+1,target) 

Base Condition: if target==0 true 
                if ind out of bound= false
                if target neg false

*/
