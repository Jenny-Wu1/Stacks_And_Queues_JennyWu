import java.util.LinkedList;
public class BalancedBrackets {
    public static String isBalanced(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.removeLast();

                if (!((c == '}' && top == '{') || (c == ']' && top == '[') || (c == ')' && top == '('))) {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
