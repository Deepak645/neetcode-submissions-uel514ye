class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Queue<Integer> q=new LinkedList<>();
        int count=0;
        Map<Integer,List<Integer>> mp=new HashMap<>();
        Map<Integer,Integer> inDegree=new HashMap<>();

        //Build a map
        for(int i=0;i<numCourses;i++){
            inDegree.put(i,0);
        }

        for(int[] pair:prerequisites){
              mp.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
              inDegree.put(pair[0],inDegree.get(pair[0])+1);
        }

        inDegree.forEach((key,value)->{
            if(value==0){
                q.offer(key);
            }
        });

        while(!q.isEmpty()){
             
             int node=q.poll();
             count++;
             for(int dep:mp.getOrDefault(node,new ArrayList<>())){

                inDegree.put(dep,inDegree.get(dep)-1);
                if(inDegree.get(dep)==0) q.offer(dep);

             }

        }

        return count==numCourses;
        
    }
}
