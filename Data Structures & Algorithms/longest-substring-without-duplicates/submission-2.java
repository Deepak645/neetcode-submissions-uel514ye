class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left=0;
        Set<Character> set=new HashSet<>();
        int ans=0;

        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);

          
            while(set.contains(ch)){
               set.remove(s.charAt(left++));
            }
           
            

            set.add(ch);
            ans=Math.max(ans,right-left+1);
        }

        return ans;
    }
}
