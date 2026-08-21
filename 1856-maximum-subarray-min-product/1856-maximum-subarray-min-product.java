class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Stack<Integer> stack = new Stack<>();
        long ans = 0;

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                   (i == n || nums[stack.peek()] > nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int right = i - 1;

                long sum = prefix[right + 1] - prefix[left];

                ans = Math.max(ans, sum * nums[mid]);
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return (int)(ans % 1_000_000_007);
    }
}