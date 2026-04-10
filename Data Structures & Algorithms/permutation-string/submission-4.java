class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] fre=new int[26];
        int required=s1.length(),left=0;

        for(int i=0;i<s1.length();i++){
            fre[s1.charAt(i)-'a']++;
        }

        for(int right=0;right<s2.length();right++){

            if(fre[s2.charAt(right)-'a']>0){
                required--;
            }
            
            fre[s2.charAt(right)-'a']--;

            if(right-left+1>s1.length()){
                if( fre[s2.charAt(left)-'a'] >=0 ) required++;
                fre[s2.charAt(left)-'a']++;
                left++;
               
            }

            
            if(required==0 && right-left+1==s1.length() ) return true;

        }

        return false;
    }
}
