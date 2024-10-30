package solutions.hard.again;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int totalElements = n1 + n2;
        int leftPortion = (n1 + n2 + 1)/2;

        int low = 0, high = n1; // defining search space on smaller array
        while (low<=high){
            int mid1 = (low + high)/2;  // num of elements to select from the smaller array
            int mid2 = leftPortion - mid1;   // num of elements remaining to be selected from the larger array

            int l1 = mid1>0 ? nums1[mid1-1]:Integer.MIN_VALUE;  // as long as there are elements to select on the left, assign l1=nums1[mid1-1]
            int l2 = mid2>0 ? nums2[mid2-1]:Integer.MIN_VALUE;
            int r1 = mid1<n1 ? nums1[mid1]:Integer.MAX_VALUE;
            int r2 = mid2<n2 ? nums2[mid2]:Integer.MAX_VALUE;

            if (l1<=r2 && l2<=r1){
                if (totalElements%2==1) return Math.max(l1, l2);
                return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
            }
            else if (l1>r2) high = mid1 - 1;    // if l1 is already greater, then we cannot increase anymore. Even if we do the result will still be l1>r2
            else if (l2>r1) low = mid1 + 1; // mid1 will increase, mid2 will reduce. So lesser elements to be selected from the other/bottom array
        }

        return 0;
    }
}
