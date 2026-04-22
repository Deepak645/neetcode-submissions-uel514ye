class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        int[] ans=new int[numCourses];
        Queue<Integer> que=new LinkedList<>();
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Map<Integer,Integer> inD=new HashMap<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            inD.put(i,0);
        }

        for(int[] pair:prerequisites){

            graph.computeIfAbsent(pair[1],k->new ArrayList<>()).add(pair[0]);
            inD.put(pair[0],inD.get(pair[0])+1);
        }

        inD.forEach((key,value)->{
            if(value==0) que.offer(key);
        });

        int ind=0;

        while(!que.isEmpty()){
            int node=que.poll();
            ans[ind++]=node;  
            count++;          
            for(int nb:graph.getOrDefault(node,new ArrayList<>())){
                inD.put(nb,inD.get(nb)-1);
                if(inD.get(nb)==0) que.offer(nb);
            }

        }

        return count==numCourses?ans:new int[]{};
    }

    
}
