package in.ravi.practice.grokking.mergerintervals;
import java.util.*;

class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<Interval>();

        //take two pointers one on each list
        int i = 0;
        int j = 0;
        while( i < arr1.length && j < arr2.length) {
            //check if the two intervals pointed by the two pointers overlap
            //they will overlap when the start time of 1 interval lies within the other interval
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) ||
                    (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)
            ) {
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }

            if (arr1[i].end < arr2[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new Interval[result.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
