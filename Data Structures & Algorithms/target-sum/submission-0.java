class Solution {
    public int findTargetSumWays(int[] nums, int target) {

       Map<String,Integer> memo=new HashMap<>();
       return check(nums,target,0,memo);

        
    }

    public int check(int[] nums,int target,int ind,Map<String,Integer> memo){
        if(ind==nums.length && target==0) return 1;

        if(ind==nums.length) return 0;

        String key=ind+","+target;

        if(memo.containsKey(key)) return memo.get(key);

        int ans= check(nums,target-nums[ind],ind+1,memo)+
               check(nums,target+nums[ind],ind+1,memo); 
        
        memo.put(key,ans);

        return ans;
    }
}
