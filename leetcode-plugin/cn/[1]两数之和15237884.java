class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int num = nums[i] + nums[j];
				if (num == target) {
					int[] returnInts = { i, j };
					return returnInts;
				}
			}
		}
		return null;
    }
}
//runtime:58 ms
//memory:40.7 MB
