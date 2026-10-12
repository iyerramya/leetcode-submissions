class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int addNum = 1;
        for(int i=digits.length-1; i>=0; i--) {
            int sum = digits[i]+addNum;
            res.add(sum%10);
            addNum = sum/10;
        }
        if(addNum > 0) {
            res.add(addNum);
        }
        int[] retArr = new int[res.size()];

        int j = res.size() - 1;
        for(int i=0; i<retArr.length; i++) {
            retArr[i] = res.get(j--);
        }

        return retArr;
    }
}