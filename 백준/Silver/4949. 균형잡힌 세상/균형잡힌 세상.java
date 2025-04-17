import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }

            sb.append(getAnswer(str)).append("\n");
        }

        System.out.println(sb);


    }


    private static String getAnswer(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return "no";
                }

                if ((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']')) {
                    stack.pop();
                } else {
                    return "no";
                }
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }
}
