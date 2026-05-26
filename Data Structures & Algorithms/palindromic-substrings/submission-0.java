class Solution {
    public int countSubstrings(String s) {
         int sum=0;

         for(int i=0;i<s.length();i++){
            sum+=count(s,i,i);
            sum+=count(s,i,i+1);
         }

         return sum;
        
    }

    public int count(String s,int i,int j){
        int count=0;

        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            count++;
        }

        return count;
    }
}
