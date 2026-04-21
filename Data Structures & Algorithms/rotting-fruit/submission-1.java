class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<List<Integer>> que=new LinkedList<>();
        int count=0;
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){               
               if(grid[i][j]==2){
                que.offer(Arrays.asList(i,j));
               }
               if(grid[i][j]==1) fresh++;
            }
        }

        while(!que.isEmpty() && fresh>0){

            int size=que.size();
            count++;
            for(int i=0;i<size;i++){
                
               List<Integer> pair=que.poll();
               int x=pair.get(0);
               int y=pair.get(1);

               int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

               for(int[] dir:dirs){
                int new_x=x+dir[0];
                int new_y=y+dir[1];

                if(new_x>=0 && new_x<grid.length && new_y >=0 && new_y < grid[0].length && grid[new_x][new_y]==1){
                    grid[new_x][new_y]=2;
                    que.offer(Arrays.asList(new_x,new_y));
                    fresh--;
                }

               }
            }


        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }

        }

    return count;
        
    }
}
