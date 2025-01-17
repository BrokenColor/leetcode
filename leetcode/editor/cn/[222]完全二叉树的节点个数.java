//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
// 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     *递归暴力查询
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = countNodes(root.left);
//        int right = countNodes(root.right);
//        return left + right + 1;
//    }

    /**
     * 二分查找 + 位运算
     * 时间复杂度：O(log^2 n)
     * 空间复杂度：O(1)
     */
    public int countNodes(TreeNode root) {
        //根节点不存在返回0
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        //根据完全二叉树特性，查出树的深度（从根节点出发，每次访问左子节点，直到遇到叶子节点）
        while (node.left != null) {
            level++;
            node = node.left;
        }
        //low：最左边叶子节点，high：最右边叶子节点
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            //为二分查找找中间数
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * 判断是否
     * @param root
     * @param level
     * @param k
     * @return
     */
    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
