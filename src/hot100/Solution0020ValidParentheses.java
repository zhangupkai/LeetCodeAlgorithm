package hot100;

import java.util.Stack;

/**
 * @Description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/3/11 20:48
 */
public class Solution0020ValidParentheses {
    public static boolean isValid(String s) {
        // 有效字符串长度一定是偶数
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (stack.empty()) {
                stack.push(c);
            }
            else {
                if ((c == ')' && stack.peek() == '(')
                        || (c == '}' && stack.peek() == '{')
                        || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[)"));
    }
}
