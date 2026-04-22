class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length!=n-1) return false;
 
        Map<Integer,List<Integer>> graph=new HashMap<>();
        int[] visited=new int[n];
        int count=0;

        for(int[] edge:edges){
            graph.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1],k->new ArrayList<>()).add(edge[0]);
        }


     for(int i=0;i<n;i++){
        if(visited[i]==0){
            count++;
            if(count>1){
                return false;
            }else{
                dfs(visited,graph,i);
            }
        }
     }


    return true;

    }

    public void dfs(int[] vis,Map<Integer,List<Integer>> graph,int node){

        vis[node]=1;

        for(int nb: graph.getOrDefault(node,new ArrayList<>())){
            
            if(vis[nb]==0){
                dfs(vis,graph,nb);
            }
        }

    }
}
