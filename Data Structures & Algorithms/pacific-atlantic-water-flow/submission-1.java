class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] pacific = new int[row][col];
        int[][] atlantic = new int[row][col];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            bfs(pacific, heights, i, 0);
        }

        for (int i = 0; i < col; i++) {
            bfs(pacific, heights, 0, i);
        }

        for (int i = 0; i < row; i++) {
            bfs(atlantic, heights,i, col - 1);
        }

        for (int i = 0; i < col; i++) {
            bfs(atlantic, heights,row-1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] == 1 && pacific[i][j] == atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void bfs(int[][] visited, int[][] heights, int i, int j) {
        Queue<List<Integer>> que = new LinkedList<>();
        int rl = heights.length;
        int cl = heights[0].length;

        que.offer(Arrays.asList(i, j));
        visited[i][j] = 1;
        while (!que.isEmpty()) {
           
                 List<Integer> ind = que.poll();
                 int x = ind.get(0);
                 int y = ind.get(1);
                 int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

                for (int[] dir : dirs) {
                    int n_x = x + dir[0];
                    int n_y = y + dir[1];

                    if (n_x >= 0 && n_x < rl && n_y >= 0 && n_y < cl && visited[n_x][n_y] == 0
                        && heights[n_x][n_y] >= heights[x][y]) {
                        que.offer(Arrays.asList(n_x, n_y));
                        visited[n_x][n_y] = 1;
                    }
                }
            
        }
    }
}
