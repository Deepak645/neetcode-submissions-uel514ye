class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character,Integer> freq=new HashMap<>();
        int count=0,tLen=t.length(),left=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<t.length();i++){
            freq.put(t.charAt(i),freq.getOrDefault(t.charAt(i),0)+1);
        }

        for(int right=0;right<s.length();right++){

            char ch=s.charAt(right);

            if(freq.containsKey(ch)){
                  
                  if(freq.get(ch)>0) {                    
                    count++;
                  }

                  freq.put(ch,freq.get(ch)-1);
            }

            if(count==tLen){          

             while(left<=right){
                if(!freq.containsKey(s.charAt(left))) {left++; continue;}

                   if(freq.get(s.charAt(left))==0) {
                    count--;
                    StringBuilder tmp=new StringBuilder(s.substring(left,right+1));
                    if(ans.length()>0 && tmp.length() < ans.length()){
                         ans=tmp;
                    }
                    if(ans.length()==0) ans=tmp;

                    freq.put(s.charAt(left),freq.get(s.charAt(left))+1);
                    left++;
                    break;
                    }
                      freq.put(s.charAt(left),freq.get(s.charAt(left))+1);
                      left++;

             }


            }
        }

        return ans.toString();
        
    }
}
