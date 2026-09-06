class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList <int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int[][] n1 = firstList;
        int[][] n2= secondList;

        while(i<n1.length && j<n2.length) {
            int start = Math.max(n1[i][0], n2[j][0]);
            int end = Math.min(n1[i][1], n2[j][1]);

            if(start <= end) {
                ans.add(new int[]{start, end});
            }

            if(n1[i][1] < n2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(int[][]::new);
    }
}