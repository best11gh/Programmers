import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            sb.append(checkVps(br.readLine()) ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean checkVps(String line) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : line.toCharArray()) {
            if (ch == '('){
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
