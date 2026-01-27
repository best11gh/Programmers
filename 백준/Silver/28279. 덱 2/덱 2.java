import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            Integer output = null;
            switch (command) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    output = deque.isEmpty() ? -1 : deque.pollFirst();
                    break;
                case 4:
                    output = deque.isEmpty() ? -1 : deque.pollLast();
                    break;
                case 5:
                    output = deque.size();
                    break;
                case 6:
                    output = deque.isEmpty() ? 1 : 0;
                    break;
                case 7:
                    output = deque.isEmpty() ? -1 : deque.peekFirst();
                    break;
                case 8:
                    output = deque.isEmpty() ? -1 : deque.peekLast();
                    break;
            }

            if (output != null) {
                sb.append(output).append("\n");
            }
        }
        System.out.println(sb);
    }
}
