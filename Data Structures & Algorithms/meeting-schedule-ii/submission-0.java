/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        Collections.sort(intervals,(a,b)->a.start-b.start);
        int count=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(Interval timing: intervals){
            int currentStart=timing.start;
            int currentEnd=timing.end;

            if(minHeap.isEmpty()){
                count++;
                minHeap.offer(currentEnd);
                continue;
            }

            if(currentStart<minHeap.peek()){
                count++;
              
            }else{
                minHeap.poll();            
            }
              
            minHeap.offer(currentEnd);
        }

        return count;

    }
}
