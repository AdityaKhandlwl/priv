class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ws = 0;
        int we = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;

        while (we < n) {
            char ch = s.charAt(we);
            if(set.contains(ch)) {
                while(ws < we && set.contains(ch)) {
                    set.remove(s.charAt(ws));
                    ws++;
                } 
            }
            set.add(ch);
            maxLen = Math.max(maxLen, we-ws+1);
            we++;
        }
        return(maxLen == Integer.MIN_VALUE)? 0: maxLen;
    }
}