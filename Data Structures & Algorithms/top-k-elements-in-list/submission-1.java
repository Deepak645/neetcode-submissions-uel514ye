class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[k];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->
           map.get(a)-map.get(b)
        );

        for(int num:nums){
          
            map.put(num,map.getOrDefault(num,0)+1);
        
        }
      
      

        for(Integer key:map.keySet()){           
           pq.add(key);
           if(pq.size()>k) pq.poll();
        }
    
        int count=0;
       while(!pq.isEmpty()){
           ans[count]=pq.poll();
           count++;
       }

        return ans;
        
    }
}
