package solutions.medium.again;

import java.util.PriorityQueue;

public class KthLargestElementInArray2 {

    // Better time complexity
    // O(N) best case / O(N^2) worst case running time + O(1) memory
    // https://leetcode.com/problems/kth-largest-element-in-an-array/
    // https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int nums11 = findKthLargest(nums1, 2);
        System.out.println(nums11);

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int nums22 = findKthLargest(nums2, 4);
        System.out.println(nums22);
    }

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;    // can only understand with the help of any given test array like in main method
        int lo = 0, hi = nums.length-1;
        while (hi>lo){
            int i = partition(nums, lo, hi);
            if(i<k) lo = i+1;
            else if(i>k) hi = i-1;
            else break;
        }

        return nums[k];
    }

    public static int partition(int[] arr, int lo, int hi){
        int i = lo, j = hi+1;
        int pivot = arr[lo];

        while (true){
            while (less(arr[++i], pivot)){
                if(i==hi) break;
            }

            while (less(pivot, arr[--j])){
                // if(j==lo) break;
            }

            if (i>=j) break;

            exch(arr, i, j);
        }

        exch(arr, lo, j);
        return j;
    }

    public static boolean less(int a, int b){
        return a<b;
    }

    public static void exch(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
