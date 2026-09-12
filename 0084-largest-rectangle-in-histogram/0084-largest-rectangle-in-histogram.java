import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currHeight = (i == heights.length) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > currHeight) {

                int h = heights[st.pop()];

                int w;
                if (st.isEmpty()) {
                    w = i;
                } else {
                    w = i - st.peek() - 1;
                }

                ans = Math.max(ans, h * w);
            }

            st.push(i);
        }

        return ans;
    }
}