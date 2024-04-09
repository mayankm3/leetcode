package solutions.easy.again;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    // https://leetcode.com/problems/pascals-triangle
    public static void main(String[] args) {
        System.out.println(generate(4));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listOfMyLists = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> myLists = new ArrayList<>(i+1);

            for (int j = 0; j < i+1; j++) {
                if(j==0 || j==i){  // note j==i
                    myLists.add(1);
                }
                else {
                    List<Integer> previousList = listOfMyLists.get(i - 1);
                    int above1 = previousList.get(j-1);
                    int above2 = previousList.get(j);
                    myLists.add(above1+above2);
                }
            }
            listOfMyLists.add(myLists);
        }
        return listOfMyLists;
    }
}
