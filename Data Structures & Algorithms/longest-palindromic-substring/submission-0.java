class Solution {
    public String longestPalindrome(String s) {

        String ans="";

        for(int i=0;i<s.length();i++){
            String odd=solve(s,i,i);
            String even=solve(s,i,i+1);
            String temp=odd.length()>even.length()?odd:even;
            ans=ans.length()>temp.length()?ans:temp;
        }

         return ans;
        
    }

    public String solve(String s,int i,int j){

        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }

        return s.substring(i+1,j);
    }
}
