class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<List<Integer>> que=new LinkedList<>();
        int INF=Integer.MAX_VALUE;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                que.offer(Arrays.asList(i,j));
            }
        }

        while(!que.isEmpty()){

            int size=que.size();

            for(int i=0;i<size;i++){
                int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

                List<Integer> ind=que.poll();
                int ind_x=ind.get(0);
                int ind_y=ind.get(1);

                for(int[] dir:dirs){
                    int x=ind_x+dir[0];
                    int y=ind_y+dir[1];

                    if(x>=0 && x<grid.length
                       && y>=0 && y<grid[0].length && grid[x][y]==INF){

                        grid[x][y]=grid[ind_x][ind_y]+1;
                        que.offer(Arrays.asList(x,y));
                       }
                }
            }
        }
        
    }
}
