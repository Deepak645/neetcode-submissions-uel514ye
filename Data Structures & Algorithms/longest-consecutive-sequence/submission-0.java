class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> track=new HashSet<>();

        for(int num:nums){
            track.add(num);
        }
        
        int count=0;
        int result=0;

        for(int num:nums){
            if(track.contains(num-1)) continue;

            while(track.contains(num++)){
                count++;
            }

            result=Math.max(count,result);
            count=0;
        }

        return result;
    }
}
