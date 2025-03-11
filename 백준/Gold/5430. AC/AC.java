import java.io.*;
import java.util.*;

public class Main {

    private static Deque<String> deque;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < n; j++) {
                deque.add(st.nextToken());
            }

            ac(p);
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    private static void ac(String p) {
        boolean isRight = true;

        for (char language : p.toCharArray()) {
            if (language == 'R') {
                isRight = !isRight;
                continue;

            }

            if (deque.isEmpty()) {
                sb.append("error\n");
                return;
            }

            if (isRight) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }

        }

        printResult(isRight);
    }


    private static void printResult(boolean isRight) {
        sb.append("[");

        if (!deque.isEmpty()) {
            if (isRight) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }

}
