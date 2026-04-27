class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> mh = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int row = grid.length;
        int col = grid[0].length;
        int max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[row][col];
        mh.offer(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;
        while (!mh.isEmpty()) {
            int[] data = mh.poll();
            int ele = data[0];
            int x = data[1];
            int y = data[2];
            max = Math.max(max, ele);

            if (x == row - 1 && y == col - 1) return max;
                
            int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    mh.offer(new int[] {grid[nx][ny], nx, ny});
                }
            }
        }

        return max;
    }
}
