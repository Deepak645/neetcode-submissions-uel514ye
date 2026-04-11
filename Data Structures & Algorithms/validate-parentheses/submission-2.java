class Solution {
    public boolean isValid(String str) {
        
        Stack<Character> s=new Stack<>();

        char[] ch=str.toCharArray();

        for(int i=0;i<ch.length;i++){

            if(ch[i]=='(' || ch[i]== '{' || ch[i]=='['){
                s.push(ch[i]);
            }else if( ch[i]==')'  || ch[i]=='}'  || ch[i]==']' ){
                
                if(s.isEmpty()) return false;
                char top=s.pop();
                if(ch[i]==')' && top!='(' || ch[i]=='}'&& top!='{' || ch[i]==']' && top!='[') return false;
            }            
        }

        return s.isEmpty();
        
    }
}

