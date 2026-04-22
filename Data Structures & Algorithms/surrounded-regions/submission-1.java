class Solution {
    public void solve(char[][] board) {

        int row=board.length;
        int col=board[0].length;
        int[][] vis=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((i==0||j==0||i==row-1|| j==col-1) && board[i][j]=='O'){

                   dfs(board,vis,i,j);

                }
            }
        }

         for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               if(vis[i][j]==0){
                   board[i][j]='X';
               }
            }
        }


        
    }

    public void dfs(char[][] board,int[][] vis,int i,int j){

        vis[i][j]=1;
        int row=board.length;
        int col=board[0].length;
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            boolean condition=(x>=0 && x<row && y>=0 && y<col && board[x][y]=='O' && vis[x][y]==0);
            if(condition){
               dfs(board,vis,x,y);
            }
        }

    }
}
