class Solution {
    public boolean validTree(int n, int[][] edges) {

        int totalEdge=edges.length;

        if(totalEdge!=n-1) return false;

        //Build the graph

        Map<Integer,List<Integer>> graph=new HashMap<>();

        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }


        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //DFS 
        boolean[] visited=new boolean[n];
      
        for(int key:graph.keySet()){

            if(!visited[key]){
              
               
                if(dfs(key,graph,visited,-1)) return false;
            }
        }

      return true;

    }

    private boolean dfs(int node,Map<Integer,List<Integer>> graph,boolean[] visited,int parent){

        visited[node]=true;

        for(int nb:graph.get(node)){
            if(!visited[nb]){
              if (dfs(nb,graph,visited,node)) return true;
            }else if(nb!=parent) return true;
        }

        return false;
    }
}
