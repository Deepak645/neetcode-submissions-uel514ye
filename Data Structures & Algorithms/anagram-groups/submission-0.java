class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(String str:strs){
            char[] strTochar=str.toCharArray();
            Arrays.sort(strTochar);
            String sortStr=new String(strTochar);
            if(!map.containsKey(sortStr)){
                map.put(sortStr,new ArrayList<>());
            }
             map.get(sortStr).add(str);          

        }

        
            for(List<String> list:map.values()){

                ans.add(list);

            }

          return ans;
        
    }
}
