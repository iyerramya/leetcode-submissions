class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        map.forEach((key, value) -> {
            pq.offer(key);
            if(pq.size() > k) {
                pq.poll();
            }
        });
        int[] res = new int[k];
        for(int i = k-1; i>=0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}