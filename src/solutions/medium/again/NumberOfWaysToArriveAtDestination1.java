package solutions.medium.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination1 {

    // https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
    // https://www.youtube.com/watch?v=_-0mx0SmYxA
    // https://takeuforward.org/data-structure/g-40-number-of-ways-to-arrive-at-destination/
    // https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/solutions/3979418/java-step-by-step-explained-simplest-solution/
    // TC: O(ElogV)
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<CityTime>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] eachRoad:roads) {
            adjList.get(eachRoad[0]).add(new CityTime(eachRoad[1], eachRoad[2]));
            adjList.get(eachRoad[1]).add(new CityTime(eachRoad[0], eachRoad[2]));
        }

        long[] shortestTimeTo = new long[n];
        Arrays.fill(shortestTimeTo, Long.MAX_VALUE);
        shortestTimeTo[0] = 0;

        long[] waysTo = new long[n];
        waysTo[0] = 1;  // There's one way to reach the start point

        final long modulo = 1_000_000_007;    // Since the answer may be large, return it modulo 10^9 + 7

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

                // if a new shortest path is found
                if (newTime < shortestTimeTo[adjCity]){
                    shortestTimeTo[adjCity] = newTime;
                    minPQ.offer(new CityTime(adjCity, newTime));
                    waysTo[adjCity] = waysTo[city]; // update to new value
                }

                // if time is same from new path then add the no. of ways
                else if (newTime == shortestTimeTo[adjCity]){
                    waysTo[adjCity] = (waysTo[adjCity] + waysTo[city]) % modulo;
                }
            }
        }

        return (int) waysTo[n-1];
    }

    private static class CityTime{
        long city, time;

        public CityTime(long city, long time){
            this.city = city;
            this.time = time;
        }
    }
}