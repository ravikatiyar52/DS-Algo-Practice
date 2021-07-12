package in.ravi.practice.grokking.mergerintervals;

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {

        Collections.sort(meetings,(a,b) ->Integer.compare(a.start,b.start));
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.end,b.end));
        int maxSize = 0;

        for(Meeting meeting : meetings){

            //remove all meetings that have already completed
            //that is all meetings that have end time lesser than the start time of this meeting

            while(!minHeap.isEmpty() && minHeap.peek().end <= meeting.start){
                minHeap.poll();
            }

            //add this meeting
            minHeap.add(meeting);

            maxSize = Math.max(minHeap.size(),maxSize);

        }

        return maxSize;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}

