//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1){
            return false;
        }
        Map<Character,Character> map = new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack();
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
