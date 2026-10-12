class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++) {
            String s = strs[i];
            int[] anaArr = new int[26];
            for(int j=0; j<s.length(); j++) {
                anaArr[s.charAt(j) - 'a']++;
            }
            String anaStr = Arrays.toString(anaArr);
            if(!map.containsKey(anaStr)) {
                map.put(anaStr, new ArrayList<>());
            }
            map.get(anaStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

}