import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();
            sb.append(current.position).append(" ");

            if (deque.isEmpty()) break;

            int move = current.distance;
            if (move > 0) {
                moveRight(deque, move);
            } else {
                moveLeft(move, deque);
            }
        }

        System.out.println(sb);
    }

    private static void moveRight(Deque<Balloon> deque, int move) {
        for (int i = 0; i < move - 1; i++) {
            deque.addLast(deque.pollFirst());
        }
    }

    private static void moveLeft(int move, Deque<Balloon> deque) {
        for (int i = 0; i < Math.abs(move); i++) {
            deque.addFirst(deque.pollLast());
        }
    }

    private static class Balloon {
        int position;
        int distance;

        public Balloon(int position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }
}
