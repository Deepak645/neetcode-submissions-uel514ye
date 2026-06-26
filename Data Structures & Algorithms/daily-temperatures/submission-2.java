class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int len=temperatures.length;
        int[] result=new int[temperatures.length];

        Stack<int[]> stack=new Stack<>();

        for(int i=len-1;i>=0;i--){

            if(stack.isEmpty()){
                result[i]=0;
                stack.push(new int[]{temperatures[i],i});
                continue;
            }

            while(!stack.isEmpty() && stack.peek()[0]<=temperatures[i]) stack.pop();
            
            if(stack.isEmpty()){
                result[i]=0;
                stack.push(new int[]{temperatures[i],i});
                continue;
            }

            result[i]=stack.peek()[1]-i;
            stack.push(new int[]{temperatures[i],i});


        }

        return result;
        
    }
}
