class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer,List<List<Integer>>> gp=new HashMap<>();
        Queue<int[]> mh=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist=new int[n+1];
        int ans=Integer.MIN_VALUE;


        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[k]=0;
        for(int edge[]:times){
            gp.computeIfAbsent(edge[0],p->new ArrayList<>()).add(Arrays.asList(edge[1],edge[2]));
        }
       
        mh.offer(new int[]{k,0});

        while(!mh.isEmpty()){
            int[] data=mh.poll();
          
            for(List<Integer> nb:gp.getOrDefault(data[0],new ArrayList<>())){
               
               int node=nb.get(0);
               int cost=nb.get(1);

               int currDist=data[1]+cost;

               if(dist[node]>currDist){

                dist[node]=currDist;
                mh.offer(new int[]{node,dist[node]});

               }                 
            }
        }

        for(int i=1;i<n+1;i++){
           ans= Math.max(ans,dist[i]);
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
