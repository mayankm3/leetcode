package solutions.medium.again;

public class SearchinRotatedSortedArrayII {

    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    // https://www.youtube.com/watch?v=oUnF7o88_Xc
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solutions/28218/my-8ms-c-solution-o-logn-on-average-o-n-worst-case/comments/284690
    // TC: O(logn) best case and O(n) worst case
    public static void main(String[] args) {
        int[] arr1 = {1,0,1,1,1};
        System.out.println(search(arr1, 0));
//        int[] arr2 = {2,5,6,0,0,1,2};
//        System.out.println(search(arr2, 0));
//        int[] arr3 = {2,5,6,0,0,1,2};
//        System.out.println(search(arr3, 3));
        int[] arr4 = {3,1,2,3,4,3,3};
        System.out.println(search(arr4, 3));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high){
            int mid = low + (high -low ) / 2;
            
            if (nums[mid] == target) return true;
            else if (nums[low] < nums[mid]){
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (nums[low] == nums[mid]) {  // we don't know which portion of the array is sorted
                low++;
            }
            else {
                if (nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
