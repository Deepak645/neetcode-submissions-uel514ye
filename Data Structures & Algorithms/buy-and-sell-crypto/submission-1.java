class Solution {
    public int maxProfit(int[] prices) {

        int min=-1,ans=0;

        for(int i=0;i<prices.length;i++){
           if(min==-1) {min=prices[i]; continue;}

           if(prices[i]-min>0){
             ans=Math.max(ans,prices[i]-min);
           }else{
            min=prices[i];
           }
        }

        return ans;
        
    }
}
