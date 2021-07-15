//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 排序



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumProduct(int[] nums) {
        //定义最小的两个值
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        //定义最大的三个值
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        //遍历查找这5个值
        for (int x: nums) {
            if ( x < min1){
                min2 = min1;
                min1 = x;//最小值
            }else if(x < min2) {
                min2 = x;//第二小值
            }

            if (x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;//最大值
            }else if (x > max2){
                max3 = max2;
                max2 = x;//第二大值
            }else if (x > max3){
                max3 = x;//第三大值
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
