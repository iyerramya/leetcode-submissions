class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i=0; i<n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int numRooms = 0;
        
        int s = 0, e=0;

        while(s<n && e<n) {
            if(starts[s] < ends[e]) {
                numRooms++;
                s++;
            } else {
                e++;
                s++;
            }
        }

        return numRooms;

    }
}