class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i=0; i<s1.length(); i++) {
            s1Arr[s1.charAt(i)-'a']++;
        }

        for(int i=0; i<s2.length(); i++) {
            s2Arr[s2.charAt(i)-'a']++;
        }

        for(int i=0; i<s2.length(); i++) {
            char c = s2.charAt(i);
            if(s1Arr[c-'a'] == 0) {
                continue;
            }

            int end = i;
            int matches = 0;
            int[] temp = s1Arr.clone();
            while(end < s2.length()) {
                if(s1Arr[s2.charAt(end)-'a'] > 0) {
                    s1Arr[s2.charAt(end)-'a']--;
                    matches++;
                    if(matches == s1.length()) {
                        return true;
                    }
                    end++;
                } else {
                    break;
                }
            }
            s1Arr = temp;
        }
        return false;
    }
}