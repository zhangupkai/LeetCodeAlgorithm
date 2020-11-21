import java.util.Stack;

/**
 * @Description
 * @Author Kai
 * @Date 2020/11/21 14:57
 */
class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
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
