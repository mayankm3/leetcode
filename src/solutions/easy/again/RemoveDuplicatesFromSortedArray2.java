package solutions.easy.again;

public class RemoveDuplicatesFromSortedArray2 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/2983019/java-solution-explanation-runtime-1ms-beats-100/
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/11780/5-lines-c-java-nicer-loops/
    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        System.out.println(removeDuplicates(a));

        int[] b = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(b));
    }

    public static int removeDuplicates(int[] nums) {
       int pointer = nums.length == 0 ? 0:1;

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1]){
                nums[pointer++] = nums[i+1];
            }
        }

       return pointer;
    }
}
