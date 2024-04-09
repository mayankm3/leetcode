package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr1));
        int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(arr2));
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();

        if(matrix == null || matrix.length==0) return res;

        int rows = matrix.length;
        int columns = matrix[0].length;

        // To do

        return res;
    }
}
