//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode p = l1, q = l2, cur = listNode;
        //carry 表示进位数
        int carry = 0;
        while (p != null || q != null){
            //去除节点的值
            int x = (p == null)? 0 : p.val;
            int y = (q == null)? 0 : q.val;

            //进位 + l1的值 + l2的值
            int sum = carry + x + y;
            //计算 进位
            carry = sum / 10;
            //当前节点指向新创建的节点
            cur.next = new ListNode(sum % 10);
            //修改指向当前节点的指针
            cur = cur.next;
            //节点后移一位
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if (carry > 0){//如果还有进位未处理，添加节点
            cur.next = new ListNode(carry);
        }
        //返回第二个节点，因为第一个节点为0，
        return listNode.next;
    }
}