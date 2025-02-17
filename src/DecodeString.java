import java.util.Stack;

public class DecodeString {
    public static String decode(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String currentString = "";
        int currentNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(currentString);
                numStack.push(currentNum);
                currentString = "";
                currentNum = 0;
            } else if (c == ']') {
                int repeatCount = numStack.pop();
                String prevString = stack.pop();

                String repeatedString = "";
                for (int j = 0; j < repeatCount; j++) {
                    repeatedString += currentString;
                }
                currentString = prevString + repeatedString;
            } else {
                currentString += c;
            }
        }
        return currentString;
    }

    public static void main(String[] args) {
        System.out.println(decode("3[a]2[bc]"));
        System.out.println(decode("3[a2[c]]"));
        System.out.println(decode("2[abc]3[cd]ef"));
    }
}
