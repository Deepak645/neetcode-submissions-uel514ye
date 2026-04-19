class Solution {
    public int numIslands(char[][] grid) {

        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        int[][] visit=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                
                if(visit[i][j]!=1 && grid[i][j]!='0'){
                    count++;
                    dfs(visit,i,j,grid);
                }
            }
        }

        return count;
        
    }

    public void dfs(int[][] visit,int i,int j,char[][] grid){
        
        visit[i][j]=1;
        int rowLen=grid.length;
        int colLen=grid[0].length;
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir:dirs){
            int x=dir[0];
            int y=dir[1];

            int nx=i+x;
            int ny=j+y;

            if(nx>=0 && nx<rowLen && ny>=0 && ny<colLen){
                if(visit[nx][ny]!=1 && grid[nx][ny]=='1'){
                    dfs(visit,nx,ny,grid);
                }
            }
        }

        return ;
            
    }
}
