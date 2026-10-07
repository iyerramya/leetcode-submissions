class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return Math.max(nums[0]+dfs(2, nums), dfs(1,nums));
    }

    private int dfs(int i, int[] nums ) {
        if(i>=nums.length) {
            return 0;
        }
        if(memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(nums[i]+dfs(i+2, nums), dfs(i+1, nums));
        return memo[i];
    }
}