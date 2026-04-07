class Solution {

    public String encode(List<String> strs) {

        StringBuilder newStr=new StringBuilder();

        for(String s:strs){

            int size=s.length();
            newStr.append(size);
            newStr.append("#");
            newStr.append(s);

        }

        return newStr.toString();

    }

    public List<String> decode(String str) {

        StringBuilder s=new StringBuilder();
        List<String> ans=new ArrayList<>();

        int i=0;
        while(i<str.length()){

            if(str.charAt(i)!='#'){
                s.append(str.charAt(i));
                i++;
            }else{
                int size=Integer.parseInt(s.toString());
                ans.add(str.substring(i+1,i+1+size));
                i=i+1+size;
                s=new StringBuilder();
            }

        }

        return ans;

    }
}
