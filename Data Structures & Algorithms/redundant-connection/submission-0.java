class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int[] parents=new int[edges.length+1];

        for(int i=0;i<edges.length;i++){
            parents[i]=i;
        }

        for(int[] edge:edges){
            int x=edge[0];
            int y=edge[1];

            if(union(x,y,parents)) return new int[]{x,y};


        }

        return new int[]{};
        
    }

    public int find(int node,int[] parent){

        while(parent[node]!=node){
            node=parent[node];
        }

        return parent[node];

    }

    public boolean union(int node1,int node2,int[] parent){

        int px=find(node1,parent);
        int py=find(node2,parent);

        if(px==py) return true;

        parent[px]=py;
             

        return false;

    }
}
