package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] intervals = {{0, 30},{5, 10},{15, 20}};
		System.out.println(minMeetingRooms(intervals));
	}

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numRooms = 0;
        for (int[] inv : intervals) {
            int currEnding = inv[1];
            if (pq.isEmpty()) {
                pq.offer(currEnding);
                numRooms++;
            } else {
                int earliestEnding = pq.peek();
                int currBeginning = inv[0];
                if (currBeginning < earliestEnding) {
                    numRooms++;
                } else {
                    pq.poll();
                }
                pq.offer(currEnding);
            }
        }
        return numRooms;
    }
}
