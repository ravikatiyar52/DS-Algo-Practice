package in.ravi.practice.grokking.cyclicsort;

import java.util.*;

class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {

        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            if( nums[i] != nums[nums[i] -1]){
                swap(nums,i,nums[i] - 1);
            }else{
                i++;
            }
        }

        for(int k=0;k<nums.length;k++){
            if(nums[k] != k+1){
                duplicateNumbers.add(nums[k]);
            }
        }
        return duplicateNumbers;
    }

    private static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
