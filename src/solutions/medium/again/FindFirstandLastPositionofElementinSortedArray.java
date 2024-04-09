package solutions.medium.again;

public class FindFirstandLastPositionofElementinSortedArray {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/14734/easy-java-o-logn-solution/

    public int[] searchRange(int[] nums, int target) {
        int[] res = {findFirstIndex(nums, target), findLastIndex(nums, target)};
        return res;
    }

    private int findFirstIndex(int[] arr, int target){
        int index = -1;
        int low = 0, high = arr.length-1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if (target<=arr[mid]){
                high = mid-1;   // left biased
            }
            else {
                low = mid+1;
            }
            if (arr[mid]==target) index=mid;
        }

        return index;
    }

    private int findLastIndex(int[] arr, int target) {
        int index = -1;
        int low = 0, high = arr.length-1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if (target>=arr[mid]){
                low = mid+1;       // right biased
            }
            else {
                high = mid-1;
            }

            if (arr[mid]==target) index=mid;
        }

        return index;
    }
}
