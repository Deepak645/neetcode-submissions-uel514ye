class Solution {
    public void islandsAndTreasure(int[][] grid) {


    Queue<List<Integer>> que=new LinkedList<>();

    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==0){
                que.offer(Arrays.asList(i,j));
            }
        }
    }

    while(!que.isEmpty()){
        List<Integer> cell=que.poll();
        int x=cell.get(0);
        int y=cell.get(1);

        int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};

        for(int[] dir:dirs){
            int nx=x+dir[0];
            int ny=y+dir[1];

            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==Integer.MAX_VALUE){
                grid[nx][ny]=grid[x][y]+1;
                que.offer(Arrays.asList(nx,ny));

            }
        }
    }


        
    }
}
 
