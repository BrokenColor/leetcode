//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。
//
// n 是一个非负整数，并且在32位有符号整型的范围内。
//
// 示例 1:
//
//
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
//
//
// 示例 2:
//
//
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
//
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        if (n == 0) return 0;
        //牛顿迭代
//        return (int)sqrt(n, n);
        //二分查找
        return twosearch(n);
    }

    public int twosearch(int n){
        long N = n;
        long low = 1, high = (long) Math.sqrt(2 * N);
        while (low <= high){
            long mid = (high - low ) / 2 + low;
            long cost = ((mid + 1) * mid) / 2;
            if (cost <= n){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return (int)low -1;
    }

    public double sqrt(double x , int n){
        double res = (x + (2* n -x)/x) /2;//牛顿迭代 （x + n/x）/2
        if (res == x){
            return x;
        }else {
            return sqrt(res, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
