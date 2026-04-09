class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq=new int[26];

        int left=0,right=0,length=0,max=0;

        for(int i=0;i<s.length();i++){

            int ind=s.charAt(i)-'A';
            freq[ind]++;
            max=Math.max(max,freq[ind]);
            int currWindowLen=right-left+1;

            if(currWindowLen-max > k){             
                int indLeft=s.charAt(left)-'A';
                freq[indLeft]--;
                left++;                                
            }    
            
            right++;
            length=Math.max(right-left,length);      
            
        }

        return length;
        
    }
}
