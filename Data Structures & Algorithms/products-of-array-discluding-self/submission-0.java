class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            
            if(i==0) {result[i]=1; continue;}

            result[i]=result[i-1]*nums[i-1];

        }
        
        int suff=1;
        for(int i=nums.length-1;i>=0;i--){
            
            if(i==nums.length-1) {continue;}
            else{
               result[i]=result[i]*nums[i+1]*suff;
               suff*=nums[i+1];
            } 
        }

        return result;
        
    }
}  
