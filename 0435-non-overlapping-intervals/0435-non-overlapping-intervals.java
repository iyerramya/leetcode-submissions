class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int olappingIntervals = 0;
        if(intervals.length ==0) return 0;
        int y = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= y) {
                y = intervals[i][1];
            } else if(intervals[i][0] < y){
                olappingIntervals++;
                y = Math.min(y, intervals[i][1]);
            }
        }
        return olappingIntervals;
    }
}