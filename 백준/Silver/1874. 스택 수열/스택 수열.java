import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sequence.add(Integer.parseInt(br.readLine()));
        }

        int num = 1;
        for (int target : sequence) {
            while (num <= target) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                sb.setLength(0);
                sb.append("NO\n");
                System.out.print(sb);
                return;
            }
        }

        System.out.print(sb);
        br.close();
    }
}
