//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //=======迭代方式======
        ListNode pre =null, next;
        while (head != null){
            //存储下一个节点的指针，否则修改完节点指针就找不到下一个节点了
            next = head.next;
            //指针修改：把前置节点赋值给当前节点的next
            head.next = pre;
            //把处理完的节点存到pre节点上
            pre = head;
            //处理下一个节点
            head = next;
        }
        return pre;
        //====================
        //======递归方式======
//        if ( head == null || head.next == null){
//            return head;
//        }
//        //递归处理直达最后一个节点
//        ListNode newNode = reverseList(head.next);
//        //将后一个节点指针指向前一个节点
//        head.next.next =head;
//        //将前一个节点指向后一个节点的指针删除
//        head.next = null;
//        //返回头节点
//        return newNode;
        //====================
    }
}
//leetcode submit region end(Prohibit modification and deletion)
