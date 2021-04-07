package in.ravi.practice.grokking.slowAndFastPointers;

/**
 * We will use the fast and slow pointer approach to detect loop in array.
 * We need to check this from each index
 * Once new index is found we need to check if our movement direction changed from forward to backward or vice versa and in this case return false since 2 way cycle is not allowed.
 * Also current and next index are same return false since 1 element cycle is also not allowed
 */
class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {


        for(int i=0;i<arr.length;i++){

            boolean isForward = arr[i] > 0;
            int slow = arr[i];
            int fast = arr[i];

            do {
                slow = findNextIndex(arr, isForward, slow);

                if (slow == -1)
                    return false;

                fast = findNextIndex(arr, isForward, fast);
                fast = findNextIndex(arr, isForward, fast);

                if (slow != -1 && slow == fast)
                    return true;

            }while(slow != -1 && fast != -1 && slow != fast);


        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {

        int nextIndex = (currentIndex + arr[currentIndex])% arr.length;

        //if direction changes return false
        if(arr[nextIndex] >0 != isForward)
            return -1;

        //turn around for negative index
        if(nextIndex < 0)
            nextIndex+= arr.length;

        //one element cycle is not allowed
        if(nextIndex == currentIndex)
            return -1;

        return nextIndex;

    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
