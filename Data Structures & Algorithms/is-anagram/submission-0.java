class Solution {
    public boolean isAnagram(String s, String t) {

      int[] fre=new int[26];

      if(s.length()!=t.length()) return false;

      for(int i=0;i<s.length();i++){
        fre[s.charAt(i)-'a']++;
        fre[t.charAt(i)-'a']--;
      }

      for(int ind:fre){
        if(ind!=0) return false;
      }

      return true;
    }
}
