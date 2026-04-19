class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int rl=grid.length,cl=grid[0].length;
        int[][] visited=new int[rl][cl];
        int area=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                 area=Math.max(area,findArea(i,j,visited,grid));
                }
            }
        }

        return area;

        
    }

    public int findArea(int i,int j,int[][] visited,int[][] grid){
        
        visited[i][j]=1;
        int area=0;
        int rLen=grid.length;
        int cLen=grid[0].length;
        int[][] dirs=new int [][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir:dirs){
           
            int x=dir[0];
            int y=dir[1];
            int nx=i+x;
            int ny=j+y;

            if(nx>=0 && nx<rLen && ny>=0 && ny<cLen){
                if(visited[nx][ny]==0 && grid[nx][ny]==1){
                     area+=findArea(nx,ny,visited,grid);
                }
            }
        }

        return 1+area;
    }
}
