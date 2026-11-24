class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()) {
            arr[c-'a']++;
        }
        int numOdds = 0;
        for(int i=0; i<26; i++) {
            if(arr[i]%2 == 1) {
                numOdds++;
            }
        }
        return numOdds <= 1;
        
    }
}