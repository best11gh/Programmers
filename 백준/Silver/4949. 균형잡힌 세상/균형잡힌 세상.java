import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals(".")) {
            sb.append(checkVps(line) ? "yes" : "no").append("\n");
        }

        System.out.print(sb);
    }

    private static boolean checkVps(String line) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : line.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char expected = (ch == ')') ? '(' : '[';
                if (stack.pop() != expected) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
