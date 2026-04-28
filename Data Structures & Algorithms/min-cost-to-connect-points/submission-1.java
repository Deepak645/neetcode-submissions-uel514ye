class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        int[] visited = new int[points.length];
        minHeap.offer(Arrays.asList(0, 0));
       int totalCost=0;
       int count=0;

        while (count<points.length) {
            List<Integer> node = minHeap.poll();
            int ind=node.get(0);
            int cost=node.get(1);
            if (visited[ind] == 0) {
                count++;
                 visited[ind] = 1;
                totalCost += cost;
                for (int i = 0; i < points.length; i++) {

                    if(ind==i) continue;

                    int dist=Math.abs(points[ind][1]-points[i][1])+Math.abs(points[ind][0]-points[i][0]);

                    minHeap.offer(Arrays.asList(i,dist));
                }
            }
        }

        return totalCost;
    }
}
