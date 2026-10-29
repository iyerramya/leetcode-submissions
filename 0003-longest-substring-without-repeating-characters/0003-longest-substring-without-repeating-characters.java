class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int curr = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            longest = Math.max(i-left+1,longest);
        }
        return longest;

    }
}