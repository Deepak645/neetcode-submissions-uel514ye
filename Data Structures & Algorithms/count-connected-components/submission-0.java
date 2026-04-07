class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer,List<Integer>> gp=new HashMap<>();

        for(int i=0;i<n;i++){
            gp.putIfAbsent(i,new ArrayList<>());
        }

        for(int[] edge:edges){

            gp.computeIfAbsent(edge[0],k->new ArrayList<Integer>()).add(edge[1]);
            gp.computeIfAbsent(edge[1],k->new ArrayList<Integer>()).add(edge[0]);
        }


        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,gp);
            }
        }

        return count;

    }

    private void dfs(int node,boolean[] visited,Map<Integer,List<Integer>> gp){
        visited[node]=true;

        for(int nb:gp.get(node)){

            if(!visited[nb]){
                dfs(nb,visited,gp);
            }
        }

        return;
    }
}
