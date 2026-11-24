class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            int[] arr = new int[26];
            for(char c: s.toCharArray()) {
                arr[c-'a']++;
            }
            String str = Arrays.toString(arr);
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
        
    }
}