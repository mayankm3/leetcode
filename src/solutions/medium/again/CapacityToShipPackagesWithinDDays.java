package solutions.medium.again;

public class CapacityToShipPackagesWithinDDays {

    // I solved the problem by myself but couldn't code it up properly e.g., the daysTaken in the private method
    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/solutions/259944/java-binary-search/
    public int shipWithinDays(int[] weights, int days) {
        int low = 1, high = 0;

        for (int weight:weights){
            if (weight>low) low = weight;
            high += weight;
        }

        while (low<=high){
            int mid = low + (high-low)/2;

            boolean weCan = canWeShip(weights, days, mid);
            if (weCan){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canWeShip(int[] weights, int days, int capacity){
        int daysTaken = 1, sumOfWeights = 0;    // taken as 1, try with a TC. It will take at least a day

        for (int weight:weights){
            if (weight>capacity || daysTaken>days) return false;

            if (sumOfWeights + weight > capacity){
                sumOfWeights = 0;
                daysTaken++;
            }
            sumOfWeights += weight;
        }

        return daysTaken<=days;
    }
}
