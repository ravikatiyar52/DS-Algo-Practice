package in.ravi.practice.grokking.cyclicsort;

public class CyclicSort {

    public static void sort(int[] nums) {

        int i =0;
        while( i < nums.length){
            if(nums[i] != i+1 ){
                swap(nums,i,nums[i]-1);
            }else{
                i++;
            }
        }

    }

    public static void swap (int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]){
        int [] input1 = {3,1,5,4,2};
        sort(input1);
        printArray(input1);

        System.out.println();

        int [] input2 = {2,6,4,3,1,5};
        sort(input2);
        printArray(input2);

        System.out.println();

        int [] input3 = {1,5,6,4,3,2};
        sort(input3);
        printArray(input3);
    }

    private static void printArray(int[] input1) {
        for (int num : input1) {
            System.out.print(num + " ");
        }
    }
}
