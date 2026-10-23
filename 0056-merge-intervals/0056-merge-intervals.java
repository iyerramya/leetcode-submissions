class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int[] interval : intervals) {
            int size = merged.size();
            if(size==0) {
                merged.add(interval);
            } else if(merged.get(size-1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(size-1)[1] = Math.max(merged.get(size-1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]); 
        
    }
}