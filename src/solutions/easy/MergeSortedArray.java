package solutions.easy;

public class MergeSortedArray {

    public static void main(String[] args) {
        System.out.println(7/2);

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = nums2.length;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int index = m+n-1;

        while (p2>=0){  // we've to incorporate all the elements of nums2 inside nums1 by running loop.
            if (p1>= 0 && nums1[p1] > nums2[p2]){
                nums1[index] = nums1[p1];
                p1--;
            }else {
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }
    }
}
