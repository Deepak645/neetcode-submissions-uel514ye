class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] cars=new int[position.length][2];

        for(int i=0;i<position.length;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        
        Double max=Double.MIN_VALUE;
        int fleet=0;
        Arrays.sort(cars,(a,b)->b[0]-a[0]);

        for(int i=0;i<cars.length;i++){
 
              double time=(double)(target-cars[i][0])/cars[i][1];

              if(max==Double.MIN_VALUE) {max=time;fleet++;continue;}
              

              if(time>max){
                 max=time;
                 fleet++;
              }              

        }


        return fleet;
    }
}


