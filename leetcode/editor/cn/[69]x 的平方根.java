//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
//        int index = -1, l = 0, r = x;
//        while (l <= r){
//            int mid = l + (r - l) / 2;
//            if ((long)mid * mid <= x){
//                index = mid;
//                l = mid + 1;
//            }else {
//                r = mid - 1;
//            }
//        }
//        return index;

        //递归
        if (x == 0) return 0;
        return (int)recursion(x, x);
    }

    public double recursion(double i,int x){
        double res = (i + x/i) / 2;
        if (res == i){
            return res;
        }else {
            return recursion(res, x);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
