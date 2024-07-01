package algorithms;

public class QuickSort {

    // https://www.youtube.com/watch?v=COk73cpQbFQ
    // https://www.youtube.com/watch?v=3Bbm3Prd5Fo
    public static void main(String[] args) {
        int[] arr = {-1000, 3, 1, 4, 1, 5, 9, 0, 2, 6, 5, 3, 5, 1000, -1, -1, 0};

        quickSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array: ");
        for (int element : arr) {System.out.print(element + " ");}
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotElement = arr[high];
        int partitionIndex = low;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivotElement) {
                swap(arr, partitionIndex, i);
                partitionIndex++;
            }
        }

        swap(arr, partitionIndex, high);
        return partitionIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
