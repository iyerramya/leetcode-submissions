class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if(p.length() > s.length()) {
            return res;
        }

        int[] pArr = new int[26];
        for(char c : p.toCharArray()) {
            pArr[c-'a']++;
        }

        int[] curr = new int[26];
        int start=0, end=0;
        while(end<s.length()) {
            curr[s.charAt(end)-'a']++;
            if((end-start)==p.length()-1) {
                if(Arrays.equals(pArr, curr)) {
                    res.add(start);
                }
                curr[s.charAt(start)-'a']--;
                start+=1;
            }
            end+=1;
        }
        return res;
    }
}