package solutions.medium.again;

public class SingleElementinaSortedArray1 {

    // https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    // https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/100754/java-binary-search-short-7l-o-log-n-w-explanations/comments/235525
    // thanks to a hint from chatGPT I coded about 50% of the solution
    // TC1: [1,1,2,3,3,4,4,8,8]
    // TC2: [1,1,2,2,3,3,4,8,8]
    // TC3: [3,4,4,7,7,11,11]
    // TC4: [3,3,7,7,10,11,11]
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr1));
        int[] arr2 = {1,1,2,2,3,3,4,8,8};
        System.out.println(singleNonDuplicate(arr2));
        int[] arr3 = {3,4,4,7,7,11,11};
        System.out.println(singleNonDuplicate(arr3));
        int[] arr4 = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr4));
        // manually check your while(low<=high); gives ArrayIndexOutOfBoundsException
        int[] arr5 = {1, 1, 2};   //
        System.out.println(singleNonDuplicate(arr5));
    }
    public static int singleNonDuplicate(int[] nums) {
        int low =0, high = nums.length - 1;

        while (low < high){
            int mid = low + (high-low)/2;

            if (mid%2 != 0){
                if (nums[mid-1] == nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid-1;
                }
            }
            else {
                if (nums[mid+1] == nums[mid]){
                    low = mid+2;
                }
                else {
                    high = mid-1;
                }
            }
        }

        return nums[low];
    }
}
