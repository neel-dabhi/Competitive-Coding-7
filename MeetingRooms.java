// Time Complexity: O( n log k) k= number of rooms
// Space Complexity O(k)
// Runs on NeetCode: YES
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
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a,b) -> a.end - b.end);
        int room = 0;

        for(Interval meeting: intervals){
            if(room == 0){
                pq.add(meeting);
                room++;
                continue;
            }
            int endingFirst = pq.peek().end;
            // endingFirst after starttime of meeting -> room++ and add endtime of the meeting to pq
            if(endingFirst > meeting.start){
                room++;
                pq.add(meeting);
            }else{
                pq.poll();
                pq.add(meeting);
            }
        }

        return room;
    }
}
