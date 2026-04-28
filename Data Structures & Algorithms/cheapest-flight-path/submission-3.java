class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer,List<int[]>> gp=new HashMap<>();

        for(int[] flight: flights){

            gp.computeIfAbsent(flight[0],p->new ArrayList<>()).add(new int[]{flight[1],flight[2]});
        }

        PriorityQueue<int[]> mh=new PriorityQueue<>((a,b)->a[0]-b[0]);

        mh.offer(new int[]{0,src,0});
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(!mh.isEmpty()){

            int[] ele=mh.poll();
            int cost=ele[0];
            int node=ele[1];
            int stop=ele[2];

            if(node==dst) return cost;

            if(stop>k) continue;
           

            for(int[] nb:gp.getOrDefault(node,new ArrayList<>())){

                

               
                    mh.offer(new int[]{cost+nb[1],nb[0],stop+1});
                
            }
        }

        return -1;


    }
}
