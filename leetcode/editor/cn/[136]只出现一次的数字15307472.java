class Solution {
    public int singleNumber(int[] nums) {
       int a = 0;
		/**
		 * 1,交换律：a ^ b ^ c <=> a ^ c ^ b
		 * 2,任何数于0异或为任何数 0 ^ n => n
		 * 3,相同的数异或为0: n ^ n => 0
		 */
		for (int i = 0; i < nums.length; i++) {
			a ^=nums[i];
		}
		return a;
    }
}
//runtime:1 ms
//memory:40.8 MB
