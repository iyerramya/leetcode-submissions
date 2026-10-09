class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1Frequency = new int[26];

        for(int i=0; i<s1.length(); i++) {
            s1Frequency[s1.charAt(i)-'a']++;
        }
        int[] windowFrequency = new int[26];

        int start = 0, end = 0;
        while(end < s1.length()) {
            windowFrequency[s2.charAt(end++)-'a']++;
        }
        if(Arrays.equals(s1Frequency, windowFrequency)) {
            return true;
        }
        while(end < s2.length()) {
            windowFrequency[s2.charAt(start++)-'a']--;
            windowFrequency[s2.charAt(end++)-'a']++;
            if(Arrays.equals(s1Frequency, windowFrequency)) {
                return true;
            }
        }
        
        return false;
    }
}
