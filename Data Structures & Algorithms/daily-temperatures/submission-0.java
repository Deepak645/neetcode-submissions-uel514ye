class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int tLen=temperatures.length;
        int[] result=new int[tLen];
        Deque<Integer> s=new ArrayDeque<>();

        for(int i=tLen-1;i>=0;i--){

            while(!s.isEmpty() && temperatures[s.peekLast()]<=temperatures[i]){
                s.pollLast();
            }

            if(s.isEmpty()) {result[i]=0;}
            else result[i]=s.peekLast()-i;

            
            s.offerLast(i);


        }

        return result;

        
        
    }
}
