import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Num> priorityQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(priorityQueue.poll().x).append("\n");
                }
            } else {
                priorityQueue.add(new Num(x));
            }
        }

        System.out.println(sb);
    }


    private static class Num implements Comparable<Num> {
        private final int x;

        public Num(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Num o) {
            int absA = Math.abs(this.x);
            int absB = Math.abs(o.x);

            if (absA == absB) {
                return this.x - o.x;
            }

            return absA - absB;
        }
    }
}
