import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            Integer result = null;

            switch (cmd) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    result = stack.isEmpty() ? -1 : stack.pop();
                    break;
                case 3:
                    result = stack.size();
                    break;
                case 4:
                    result = stack.isEmpty() ? 1 : 0;
                    break;
                case 5:
                    result = stack.isEmpty() ? -1 : stack.peek();
                    break;
            }
            if (result != null) {
                sb.append(result).append('\n');
            }
        }
        System.out.println(sb);
    }
}
