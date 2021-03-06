package in.ravi.practice.grokking.mergerintervals;

import java.util.*;


class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        // in order to find the correct position where new interval should be put we should skip given intervals such
        //that intervals[i].end < newInterval.start

        while(i<intervals.size() && intervals.get(i).end < newInterval.start){
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        //now new interval may overlap more than 1 existing interval ? correct ?
        //so it will overlap all intervals whose start < newInterval.end

        while(i < intervals.size() && intervals.get(i).start < newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        //add the new interval
        mergedIntervals.add(new Interval(newInterval.start, newInterval.end));

        //add the remaining intervals
        while (i < intervals.size()){
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
