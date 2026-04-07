class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length>n-1) return false;

        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<Integer>());
        }

        for(int[] row:edges){
            list.get(row[0]).add(row[1]);
            list.get(row[1]).add(row[0]);
        }

        Queue<Integer> que=new LinkedList<>();
        boolean[] vis=new boolean[n];
        que.add(0);
       
        while(!que.isEmpty()){
           int peek=que.poll();
           vis[peek]=true;

           for(int nb:list.get(peek)){
            if(!vis[nb])
               que.add(nb);
               vis[nb]=true;
           }
        }

        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }

      return true;


    }
}
