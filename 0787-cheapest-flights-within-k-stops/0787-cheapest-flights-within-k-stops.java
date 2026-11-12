class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<FlightInfo> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++) {
            map.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        for(int[] s : map.get(src)) {
            pq.offer(new FlightInfo(s[0], 0, s[1]));
        }

        int[] bestStops = new int[n];
        Arrays.fill(bestStops, Integer.MAX_VALUE);

        while(!pq.isEmpty()) {
            FlightInfo curr = pq.poll();
            if (curr.stopNum >= bestStops[curr.cityNum]) continue;
            bestStops[curr.cityNum] = curr.stopNum;
            if(curr.cityNum == dst) {
                return curr.price;
            } 
            int stpNum = curr.stopNum+1;
            if(stpNum > k) {
                continue;
            } else {
                for(int[] s : map.get(curr.cityNum)) {
                     pq.offer(new FlightInfo(s[0], stpNum, curr.price+s[1]));
                }
            }
        }
        return -1;
    }
}
public class FlightInfo {
    int cityNum;
    int stopNum;
    int price;
    public FlightInfo(int c, int s, int p) {
        cityNum = c; 
        stopNum = s; 
        price = p; 
    } 


}