class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for(int curr = 0; curr<nums.length; curr++) {
            if(nums[curr] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[curr];
                nums[curr] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }
}