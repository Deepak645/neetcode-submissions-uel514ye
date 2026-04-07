class Solution {
    public boolean validTree(int n, int[][] edges) {

        //form the graph first
        if(n==1 && edges.length==0) return true;

        Map<Integer,List<Integer>> graph=new HashMap<>();
        boolean[] visited=new boolean[n];
        int count=0;
        for(int[] row: edges){
            int u=row[0];
            int v=row[1];

            graph.putIfAbsent(u,new ArrayList<Integer>());
            graph.putIfAbsent(v,new ArrayList<Integer>());
        }

        for(int[] row:edges){
            graph.get(row[0]).add(row[1]);
            graph.get(row[1]).add(row[0]);

        }

        if(graph.keySet().size()==0) return false;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
               if(dfs(graph,visited,i,-1)) return false;
            }
        }
        
     return count>1?false:true;
    }

    public boolean dfs(Map<Integer,List<Integer>> gp,boolean[] vis,int node,int parent){

        vis[node]=true;

        for(int nb:gp.get(node)){
            if(!vis[nb]){
              if(dfs(gp,vis,nb,node)) return true;
            }else if(vis[nb] && nb!=parent){
                return true;
            }
        }

        return false;
    }
}
