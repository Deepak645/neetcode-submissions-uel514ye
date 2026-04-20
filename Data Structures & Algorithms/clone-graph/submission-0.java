/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node==null) return null;

        Queue<Node> que=new LinkedList<>();
        Map<Node,Node> map=new HashMap<>();
   

        que.offer(node);
        Node clone=new Node(node.val);
        map.put(node,clone);

        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){

               Node n=que.poll();          
               for(Node nb:n.neighbors){
                    if(!map.containsKey(nb)){ 
                        map.put(nb,new Node(nb.val));
                        que.offer(nb);
                        }
                    
                    map.get(n).neighbors.add(map.get(nb));
                }
            

            }
           
        }

        return map.get(node);
        
    }
}


/*

We have root node
we will create a new node then will traverse its neibhbors and create node for them


*/