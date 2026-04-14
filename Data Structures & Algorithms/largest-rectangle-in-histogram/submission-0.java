class Solution {
    public int largestRectangleArea(int[] heights) {

      int len=heights.length;
      int left[]=new int[len];
      int right[]=new int[len];
      Deque<Integer> st=new ArrayDeque<>();

      for(int i=0;i<len;i++){

        if(st.isEmpty()){
          left[i]=heights[i]*(i+1);
          st.offerLast(i);
          continue;
        }
        
        int top=st.peekLast();
        if(heights[top]>heights[i]){
          while(!st.isEmpty() && heights[st.peekLast()]>heights[i]){
            st.pollLast();
          }

          if(st.isEmpty()){
              left[i]=heights[i]*(i+1);
          
          }else{
               left[i]=heights[i]*(i-st.peekLast());               
          }
     

        }else if(heights[top]<heights[i]){
          left[i]=heights[i]*(i-top); 
         
        }else{
          st.pollLast();
          if(st.isEmpty()) left[i]=heights[i]*(i+1);
          else left[i]=heights[i]*(i-st.peekLast()); 
         
        }
            st.offerLast(i);
      }

      st.clear();

      for(int i=len-1;i>=0;i--){

        
        if(st.isEmpty()){
          right[i]=heights[i]*(len-i);
          st.offerLast(i);
          continue;
        }
        
        int top=st.peekLast();
        if(heights[top]>heights[i]){
          while(!st.isEmpty() && heights[st.peekLast()]>heights[i]){
            st.pollLast();
          }

          if(st.isEmpty()){
              right[i]=heights[i]*(len-i);
          
          }else{
               right[i]=heights[i]*(st.peekLast()-i);               
          }
          st.offerLast(i);
        }else if(heights[top]<heights[i]){
          right[i]=heights[i]*(top-i);
          st.offerLast(i); 
        }else{
          st.pollLast();
          if(st.isEmpty()){
              right[i]=heights[i]*(len-i);          
          }else{
               right[i]=heights[i]*(st.peekLast()-i);               
          } 
          st.offerLast(i);
        }
      }
  
      int max=Integer.MIN_VALUE;

      for(int i=0;i<len;i++){
         max=Math.max(left[i]+right[i]-heights[i],max);
      }

      return max;
        
    }
}
