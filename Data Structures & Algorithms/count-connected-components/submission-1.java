class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> gp=new ArrayList<>();

        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            gp.add(new ArrayList<>());            
        }

        for(int[] edge:edges){
            gp.get(edge[0]).add(edge[1]);
            gp.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(gp,vis,i);
            }
        }


        return count;

    }

    public void dfs(List<List<Integer>> gp,boolean[] vis,int node){
        vis[node]=true;

        for(int nb:gp.get(node)){
            if(!vis[nb]){
                dfs(gp,vis,nb);
            }
        }
    }
}
