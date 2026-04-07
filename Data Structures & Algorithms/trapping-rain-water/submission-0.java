class Solution {
    public int trap(int[] height) {

        int[] rightValue=new int[height.length];
        int[] leftValue=new int[height.length];
        int maxValue=-1;
        int ans=0;
        for(int i=0;i<height.length;i++){
             if(maxValue>height[i]) leftValue[i]=maxValue;
            else { maxValue=height[i]; leftValue[i]=maxValue;}
          
        }

        maxValue=-1;
      

        for(int i=height.length-1;i>=0;i--){
              
            if(maxValue>height[i]) rightValue[i]=maxValue;
            else { maxValue=height[i]; rightValue[i]=maxValue;}
    
        }

        for(int i=0;i<height.length;i++){
           
           ans+=Math.min(leftValue[i],rightValue[i])-height[i];
        }
        
        return ans;
    }
}
