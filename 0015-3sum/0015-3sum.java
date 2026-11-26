class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int num1 = nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l < r) {
                int sum = num1 + nums[l]+nums[r];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while(l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
                if(sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return res;
        
        
    }
}