import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            Integer output = null;
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    break;

                case "pop":
                    output = queue.isEmpty() ? -1 : queue.poll();
                    break;

                case "size":
                    output = queue.size();
                    break;

                case "empty":
                    output = queue.isEmpty() ? 1 : 0;
                    break;

                case "front":
                    output = queue.isEmpty() ? -1 : queue.peek();
                    break;

                case "back":
                    output = queue.isEmpty() ? -1 : queue.peekLast();
                    break;
            }

            if (output != null) {
                sb.append(output).append("\n");
            }
        }

        System.out.println(sb);
    }
}
