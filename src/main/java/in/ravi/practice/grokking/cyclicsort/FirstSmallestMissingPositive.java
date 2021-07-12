package in.ravi.practice.grokking.cyclicsort;

class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {


        int i =0;
        while(i < nums.length){
            int j = nums[i] -1;
            if(j >= 0 && j < nums.length && nums[i] != nums[j]){
                swap(nums,i,j);
            }else{
                i++;
            }
        }

        for(int k =0; k <nums.length;k++){
            if(nums[k] != k+1){
                return k+1;
            }
        }

        return -1;
    }

    private static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]){
        int[] input1 = new int[]{-3,1,5,4,2};
        System.out.println(FirstSmallestMissingPositive.findNumber(input1));
    }
}

