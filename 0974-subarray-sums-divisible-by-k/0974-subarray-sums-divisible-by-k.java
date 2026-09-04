class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> f = new HashMap<>();

        f.put(0,1);

        int res=0;
        int sum=0;

        for(int i =0; i<n; i++) {
            sum += nums[i];
            int rem = sum % k;

            if(rem < 0) {
                rem += k;
            }

            int freq = f.getOrDefault(rem , 0);

            res += freq;

            f.put(rem, f.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}