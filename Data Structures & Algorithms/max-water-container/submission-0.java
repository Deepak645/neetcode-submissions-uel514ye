class Solution {
    public int maxArea(int[] height) {

        int left=0,right=height.length-1;
        int result=0;
        while(left<right){
           
         int temp=Math.min(height[left],height[right])*(right-left);
         result=Math.max(temp,result);
         if(height[left]<height[right]) left++;
         else right--;
        }

        return result;
        
    }
}
