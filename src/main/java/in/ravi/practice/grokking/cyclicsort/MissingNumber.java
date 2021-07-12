package in.ravi.practice.grokking.cyclicsort;

class MissingNumber {

    public static int findMissingNumber(int[] nums) {

        int i = 0;
        while (i < nums.length){
            int j = nums[i];
            if(nums[i] != i && j <= nums.length - 1){
                swap(nums,i,j);
            }else{
                i++;
            }

        }

        int missingNumber = -1;
        for(int k=0;k<nums.length;k++){
            if(nums[k] != k ){
                missingNumber = k;
                break;
            }
        }


        return missingNumber;
    }

    public static void swap (int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]){
        int arr[] = {4,0,3,1};
        int missingNumber = findMissingNumber(arr);
        System.out.println(missingNumber);
    }
}

