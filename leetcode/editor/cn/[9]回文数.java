//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
//

//class Solution {
//    public boolean isPalindrome(int x) {
//        String str = x + "";
//        //将字符串只需要遍历字符串一半，
//        for (int i = 0; i < str.length() / 2; i++) {
//            //判断对应元素是否相等
//            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//}

//class Solution {
//    public boolean isPalindrome(int x) {
//        String reverse = new StringBuffer(x + "").reverse().toString();
//        return reverse.equals(x + "");
//    }
//}
//class Solution {
//    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        int div = 1;
//        //找到最大位数
//        while (x / div >= 10) {
//            div *= 10;
//        }
//        while (x > 0) {
//            int left = x / div;
//            int right = x % 10;
//            if (left != right) {
//                return false;
//            }
//            //掐头去尾
//            x = (x % div) / 10;
//            div /= 100;
//        }
//        return true;
//    }
//}
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNum = 0;
        // 取出后半段数字进行翻转
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        /**
         * 如果是偶数的话，revertNum 和 x 相等；
         * 如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
         *
         */
        return reverseNum == x || x == reverseNum / 10;
    }
}