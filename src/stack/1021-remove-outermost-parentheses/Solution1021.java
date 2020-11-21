import java.util.Stack;

/**
 * @Description
 * @Author Kai
 * @Date 2020/11/21 14:57
 */
// https://leetcode-cn.com/problems/remove-outermost-parentheses/
class Solution1021 {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            // 什么情况下，某个括号要加入结果中呢？非外层括号。
            // 怎么判断是非外层括号？ 1. 左括号加入前，栈不为空。2. 右括号加入并消括号后，栈不为空
            if (S.charAt(i) == '(') {
                if (!stack.isEmpty()) {
                    ans.append(S.charAt(i));
                }
                stack.push(S.charAt(i));
            }
            if (S.charAt(i) == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans.append(S.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}
