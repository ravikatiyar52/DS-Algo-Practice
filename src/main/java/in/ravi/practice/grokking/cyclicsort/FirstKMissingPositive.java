package in.ravi.practice.grokking.cyclicsort;
import java.util.*;

public class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> availableNumbers = new HashSet<>();

        int i = 0;
        while(i<nums.length){
            availableNumbers.add(nums[i]);
            int j= nums[i] -1;
            if(j >0 && j <nums.length && nums[i] != nums[j])
                swap(nums,i,j);
            else
                i++;
        }

        for(int iterator = 0;iterator < nums.length;iterator++){
            if(nums[iterator] != iterator+1 && missingNumbers.size() < k)
                missingNumbers.add(iterator+1);
        }

        int missingNumber = nums[nums.length -1] + 1;
        while(missingNumbers.size() != k){
            if(!availableNumbers.contains(missingNumber))
                missingNumbers.add(missingNumber);
            missingNumber++;
        }

        return missingNumbers;
    }

    private static void swap(int arr[],int firstIndex,int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] =  arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void main(String args[]){
        int input1[] = {3,-1,4,5,5};
        List<Integer> output1 = findNumbers(input1,3);
        for(int number:output1){
            System.out.print(number + " ");
        }
        System.out.println();

        int input2[] = {2,3,4};
        List<Integer> output2 = findNumbers(input2,3);
        for(int number:output2){
            System.out.print(number + " ");
        }
        System.out.println();

        int input3[] = {-2,-3,4};
        List<Integer> output3 = findNumbers(input3,2);
        for(int number:output3){
            System.out.print(number + " ");
        }
    }
}
