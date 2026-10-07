class Solution {
    public int climbStairs(int n) {
        int nMinusTwo = 1;
        int nMinusOne = 2;
        if(n == 1) {
            return nMinusTwo;
        } 
        if(n == 2) {
            return nMinusOne;
        }
        for(int i=3; i<=n; i++) {
            int temp = nMinusTwo + nMinusOne;
            nMinusTwo = nMinusOne;
            nMinusOne = temp;
        }
        return nMinusOne;

    }
}