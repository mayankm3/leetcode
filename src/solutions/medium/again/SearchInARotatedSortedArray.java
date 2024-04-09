package solutions.medium.again;

public class SearchInARotatedSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {4,5,6,7,0,1,2};
        System.out.println(search(arr1, 0));
        int[] arr2 = {4,5,6,7,0,1,2};
        System.out.println(search(arr2, 3));
        int[] arr3 = {1};
        System.out.println(search(arr3, 0));
    }

    public static int search(int[] nums, int target){
        int low = 0;
        int high  = nums.length-1;
        while(low<=high){   // variation based on mo10's reply and acamillo's reply to tld's reply
            int mid = low + (high-low)/2; // (low+high)/2 might cause integer overflow

            if(nums[mid] == target) return mid;

            if(nums[low]<=nums[mid]){   // Why = in if? See acamillo's reply to tld's reply
                if (target>=nums[low] && target<nums[mid]){
                    high = mid - 1;
                }
                else {
                    low = mid +1;
                }
            }else {
                if (target>nums[mid] && target<=nums[high]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
