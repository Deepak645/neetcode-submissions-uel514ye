class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> window=new HashSet<>();
        int ans=0,right=0,left=0;

        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(window.contains(ch)){
                int len=right-left;
                ans=Math.max(len,ans);

                while(s.charAt(left)!=ch){
                    window.remove(s.charAt(left));
                    left++;
                }

                left++;
                right++;

            }else{
                window.add(ch);
                right++;
            }
        }

      return Math.max(ans,right-left);        
    }
}

