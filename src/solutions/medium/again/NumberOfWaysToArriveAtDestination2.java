package solutions.medium.again;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination2 {

    // https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
    // https://www.youtube.com/watch?v=_-0mx0SmYxA
    // https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/solutions/3979418/java-step-by-step-explained-simplest-solution/
    // This is more 'optimized'
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<CityTime>> adjList = new ArrayList<>(n);

        long[] shortestTime = new long[n];
        long[] waysToDest = new long[n];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            shortestTime[i] = Long.MAX_VALUE;
        }
        shortestTime[0] = 0;
        waysToDest[0] = 1;

        for (int[] eachRoad:roads) {
            adjList.get(eachRoad[0]).add(new CityTime(eachRoad[1], eachRoad[2]));
            adjList.get(eachRoad[1]).add(new CityTime(eachRoad[0], eachRoad[2]));
        }

        long modulo = 1_000_000_007;    // Since the answer may be large, return it modulo 10^9 + 7

        PriorityQueue<CityTime> minPQ = new PriorityQueue<>((first,second)->Long.compare(first.time, second.time));
        minPQ.add(new CityTime(0, 0));

        while (!minPQ.isEmpty()){
            CityTime cityTime = minPQ.poll();
            int city = (int) cityTime.city;
            long time = cityTime.time;

            for (CityTime neighbour:adjList.get(city)) {
                int adjCity = (int) neighbour.city;
                long timeToAdjCity = neighbour.time;

                long newTime = time+timeToAdjCity;

                if (newTime < shortestTime[adjCity]){
                    shortestTime[adjCity] = newTime;
                    minPQ.offer(new CityTime(adjCity, newTime));
                    waysToDest[adjCity] = waysToDest[city];
                }
                else if (newTime == shortestTime[adjCity]){
                    waysToDest[adjCity] = (waysToDest[adjCity] + waysToDest[city]) % modulo;
                }
            }
        }

        return (int) waysToDest[n-1];
    }

    private record CityTime(long city, long time){}
}