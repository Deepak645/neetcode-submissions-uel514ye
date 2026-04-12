class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();

        for(String str:strs){
            char[] strToChar=str.toCharArray();
            Arrays.sort(strToChar);
            String newStr=new String(strToChar);

            map.putIfAbsent(newStr,new ArrayList<>());
            map.get(newStr).add(str);
        }

        for(List<String> arr:map.values()){
            ans.add(arr);
        }
        
       return ans;
        

        
    }
}
