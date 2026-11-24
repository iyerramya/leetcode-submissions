class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        map.forEach((key, value) -> {
            pq.offer(new int[]{key, value});
            if(pq.size() > k) {
                pq.poll();
            }
        });
        int[] res = new int[k];
        for(int i = k-1; i>=0; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}