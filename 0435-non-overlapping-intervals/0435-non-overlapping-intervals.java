class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int number = 0;
        
        if(n<=1){
            return number;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int end1 = intervals[0][1];
        
        for(int i = 1; i<n; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];
            
            if (end1 > start2) {
            number++;

            end1 = Math.min(end1, end2);
            } else  {
            end1 = end2;
            }
        }
        return number;
    }
}