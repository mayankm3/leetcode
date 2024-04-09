package solutions.medium.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    // https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/115541/java-c-python-priority-queue-solution-tle-now/
    // Solution based upon anotherFlip's reply to vivan1790

    public static void main(String[] args) {
        CheapestFlightsWithinKStops cfk = new CheapestFlightsWithinKStops();
//        int[][] arr1 = {{0,1,2},{1,2,1},{2,0,10}};
//        int num1 = cfk.findCheapestPrice(3, arr1, 1,2,3);
//        System.out.println(num1);

//        int[][] arr2 = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
//        int num2 = cfk.findCheapestPrice(4, arr2, 0,3,2);
//        System.out.println(num2);

        int[][] arr3 = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int num3 = cfk.findCheapestPrice(5, arr3, 0,2,2);
        System.out.println(num3);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] visited = new int[n] ;
        Arrays.fill(visited,-1);

        ArrayList<ArrayList<CityStopCost>> adjList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new CityStopCost(flight[1], 0, flight[2]));
        }

        PriorityQueue<CityStopCost> pq = new PriorityQueue<>();
        pq.offer(new CityStopCost(src,0,0));

        while(!pq.isEmpty()){
            CityStopCost triplet = pq.poll();
            int city = triplet.city;
            int stopNum = triplet.stop;
            int totalCost = triplet.cost;

            if(city == dst) return totalCost;

            if(stopNum > k) continue;   // no point in going ahead in this path
            if(visited[city]>-1 && stopNum>visited[city]){ // continue if already visited and ?couldn't understand?
                continue;
            }

            visited[city] = stopNum;

            for(CityStopCost adj : adjList.get(city)){
                pq.offer(new CityStopCost(adj.city,stopNum+1,totalCost + adj.cost));
            }
        }

        return -1;
    }

    private static class CityStopCost implements Comparable<CityStopCost> {
        int city, stop, cost;

        public CityStopCost(int city, int stop , int cost ) {
            this.city = city;
            this.stop = stop;
            this.cost = cost;
        }

        public int compareTo(CityStopCost that) {
            return Integer.compare(this.cost, that.cost);
        }
    }
}
