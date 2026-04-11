class Solution {
    public boolean isValid(String str) {
        
        Stack<Character> s=new Stack<>();

        char[] ch=str.toCharArray();

        for(int i=0;i<ch.length;i++){

            if(s.isEmpty()){ s.push(ch[i]); continue; }

            char sTop=s.peek();

            if(ch[i]=='(' || ch[i]== '{' || ch[i]=='['){
                s.push(ch[i]);
            }else if( (ch[i]==')' && sTop=='(') || (ch[i]=='}' && sTop=='{') || (ch[i]==']' && sTop=='[')){
                s.pop();
            }else{
                return false;
            }
        }

        return s.isEmpty();
        
    }
}

