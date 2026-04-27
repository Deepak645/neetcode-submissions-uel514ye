class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> gp = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            gp.computeIfAbsent(from, k->new PriorityQueue<>()).offer(to);
        }

        dfs(gp,ans,"JFK");

        return ans;
    }

    public void dfs(Map<String, PriorityQueue<String>> gp, List<String> ans, String node) {
       
        while(!gp.getOrDefault(node,new PriorityQueue<>()).isEmpty()){
            String next=gp.get(node).poll();
            dfs(gp,ans,next);
        }
      
        ans.add(0, node);
        
    }
}
