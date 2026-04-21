class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int row=heights.length;
        int col=heights[0].length;
        int[][] pacific=new int[row][col];
         int[][] atlantic=new int[row][col];
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<col;i++){
            check(pacific,heights,0,i);
        }
        
        for(int j=0;j<row;j++){
            check(pacific,heights,j,0);
        }

         for(int j=0;j<row;j++){
            check(atlantic,heights,j,col-1);
        }

         for(int j=0;j<col;j++){
            check(atlantic,heights,row-1,j);
        }

       
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(pacific[i][j]==1 && atlantic[i][j]==1){
                ans.add(Arrays.asList(i,j));
            }
        }
       }

       return ans;


    }

    public void check(int[][] vis,int[][] h,int i,int j){

        vis[i][j]=1;

        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];

            if(x>=0 && x<h.length && y>=0 && y<h[0].length){
                if(vis[x][y]==0 && h[x][y]>=h[i][j]){
                    check(vis,h,x,y);
                }
            }
        }
    }
}
