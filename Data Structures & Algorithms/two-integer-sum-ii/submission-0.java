class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int i=0,j=numbers.length-1;

        while(i<j){
            int f=numbers[i];
            int s=numbers[j];

            if(f+s > target){
                j--;
            }else if(f+s < target){
                i++;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        
        return new int[2];
    }
}
