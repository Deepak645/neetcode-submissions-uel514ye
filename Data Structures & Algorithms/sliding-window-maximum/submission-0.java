class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans=new int[nums.length-k+1];      
        Deque<Integer> dq=new ArrayDeque<>();    

        int left=0,ind=0;                         

        for(int right=0;right<nums.length;right++){
         
           if(dq.isEmpty()){
            dq.offerLast(right);
           }else{
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
           }

           if(right-left+1==k){
            ans[ind++]=nums[dq.peekFirst()];
            if(dq.peekFirst()<=right-k+1){
                dq.pollFirst();
            }
            left++;
           }
         
            
        }

        return ans;
        
    }
}


