class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character,Integer> mp=new HashMap<>();
        int count=0,s1Len=s1.length(),left=0,right=0;

        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<s2.length();i++){

            char ch=s2.charAt(i);

            if(mp.containsKey(ch)){
                int getChCount=mp.get(ch);

                if(getChCount==0){
                       if(count==s1Len)  return true;
                       else {
                        while(s2.charAt(left)!=ch) {
                            char leftCh=s2.charAt(left);
                            left++;
                            count--;
                            mp.put(leftCh,mp.get(leftCh)+1);
                         }

                         left++;
  
                       }

                }else{
                    mp.put(ch,mp.get(ch)-1);                  
                    count++;
                   
                    
                }  
                right++;            
                
            }else{
                
                if(count==s1Len)  return true;
                left=i+1;
                if(count!=0){
                count=0;
                mp.clear();
                for(int k=0;k<s1.length();k++){
                    mp.put(s1.charAt(k),mp.getOrDefault(s1.charAt(k),0)+1);
                 }    
                }

                right=left;                        
            }

        }

        return count==s1.length();
        
    }
}
