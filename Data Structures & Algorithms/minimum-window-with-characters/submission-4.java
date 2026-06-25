class Solution {
    public String minWindow(String s, String t) {

        if(s.length()<t.length()) return "";

        Map<Character,Integer> map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int len=t.length();
        int j=0,i=0;
        int start=-1,end=-1;
        int ans=Integer.MAX_VALUE;
         for(;i<s.length();i++){

            char ch=s.charAt(i);

            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                    len--;                                       
                }
                map.put(ch,map.get(ch)-1);
                 if(len==0){
                                             
                        while(!map.containsKey(s.charAt(j)) || map.get(s.charAt(j))<0){                 
                            if(map.containsKey(s.charAt(j))){
                                map.put(s.charAt(j),map.get(s.charAt(j))+1);
                            }
                            j++;
                        }
                           map.put(s.charAt(j),map.get(s.charAt(j))+1);
                         
                          

                         if(ans>i-j+1){
                            start=j;
                            end=i;
                            ans=i-j+1;
                            }  

                        len++;
                        j++;
                       
                    }
            }
        
        }
        return start!=-1?s.substring(start,end+1):"";
   }    
    
}
