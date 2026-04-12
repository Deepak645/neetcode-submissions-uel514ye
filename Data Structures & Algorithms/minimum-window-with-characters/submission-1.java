class Solution {
    public String minWindow(String s, String t) {

        int required=t.length();
        int left=0;
        int len=Integer.MAX_VALUE,start=-1,end=0;

        Map<Character,Integer> map=new HashMap<>();

        for(Character ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int right=0;right<s.length();right++){

            char ch=s.charAt(right);

            if(!map.containsKey(ch)) continue;

            if(map.containsKey(ch) && map.get(ch)>0) {
                required--;
                }
            
            map.put(ch,map.get(ch)-1);

            if(required==0){
                
                while(required==0){
                    char chAtLeft=s.charAt(left);
                    if(!map.containsKey(s.charAt(left))){ left++; continue;}
                    if(map.containsKey(s.charAt(left)) && map.get(chAtLeft)>=0) {
                        required++;    
                         if(right-left+1<len){
                                start=left;
                                end=right;
                                len=right-left+1;
                                }                     
                        }
                    
                    map.put(chAtLeft,map.get(chAtLeft)+1);
                    left++;
                }

               
            }       


        }


        return len==Integer.MAX_VALUE?"":s.substring(start,end+1);
        
    }
}
