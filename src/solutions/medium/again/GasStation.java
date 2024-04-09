package solutions.medium.again;

public class GasStation {

    // https://leetcode.com/problems/gas-station/description
    // https://www.youtube.com/watch?v=3wUa7Lf1Xjk
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int position = 0, total = 0, sum = 0;

        for (int i = 0; i < gas.length; i++) {
            sum = (gas[i]+sum) - cost[i];

            if (sum<0){
                total += sum;
                sum = 0;
                position = i+1;
            }
        }

        total = total+sum;

        return total>=0?position:-1;
    }
}
