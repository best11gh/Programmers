import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int position = 1;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == position) {
                position++;
            } else {
                stack.push(num);
            }

            while (!stack.isEmpty() && stack.peek() == position) {
                stack.pop();
                position++;
            }
        }
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}
