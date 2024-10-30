package solutions.hard.again;

public class MinimizeMaxDistancetoGasStation {

    // https://leetcode.com/problems/minimize-max-distance-to-gas-station/
    public static boolean canPlaceStations(int[] stations, int distance, int maxStations) {
        int count = 1;  // Start with the first station placed
        int lastPosition = stations[0];  // Place the first station at the first point

        for (int i = 1; i < stations.length; i++) {
            if (stations[i] - lastPosition >= distance) {
                count++;
                lastPosition = stations[i];
                if (count == maxStations) {  // If we've placed enough stations
                    return true;
                }
            }
        }

        return count >= maxStations;  // Check if we placed the required number of stations
    }

    public static int minimizeMaxDistance(int[] stations, int maxStations) {
        int low = 1;  // Minimum distance
        int high = stations[stations.length - 1] - stations[0];  // Maximum possible distance

        while (low <= high) {
            int mid = (low + high) / 2;  // Check the middle distance
            if (canPlaceStations(stations, mid, maxStations)) {
                high = mid - 1;  // Try for a smaller max distance
            } else {
                low = mid + 1;  // Increase the distance
            }
        }

        return low;  // This is the minimized maximum distance
    }

    public static void main(String[] args) {
        int[] stations1 = {1,2,3,4,5,6,7,8,9,10};  // Positions of the stations
        int[] stations2 = {23,24,36,39,46,56,57,65,84,98};  // Positions of the stations
        int maxStations = 9;  // Number of gas stations to place
        int result = minimizeMaxDistance(stations1, maxStations);
        System.out.println("The minimized maximum distance is: " + result);
    }
}
