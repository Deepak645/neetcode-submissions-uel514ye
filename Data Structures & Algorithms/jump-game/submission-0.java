class Solution {
    public boolean canJump(int[] nums) {
        return check(nums,0);
    }

    public boolean check(int[] nums,int ind){
        
        if(ind>=nums.length-1) return true;

        for(int i=1;i<=nums[ind];i++){

            if(check(nums,ind+i)) return true;

        }

        return false;
    }
}
