class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack=new ArrayDeque<>();

        for(String s:tokens){

            if("+".equals(s)||"-".equals(s)||"*".equals(s)||"/".equals(s)){

                int second=stack.pollLast();
                int first=stack.pollLast();

                switch(s){
                    case "+":
                    stack.offerLast(first+second);
                    break;
                    case "-":
                    stack.offerLast(first-second);
                    break;
                    case "*":
                    stack.offerLast(first*second);
                    break;
                    case "/":
                    stack.offerLast(first/second);
                    break;
                }
                
            }else{
              int val=Integer.parseInt(s);
              stack.offerLast(val);
            }

           
        }

        return stack.peekLast();
        
    }
}
