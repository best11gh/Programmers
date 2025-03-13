import java.io.*;
import java.util.PriorityQueue;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static final PriorityQueue<Integer> heap = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            calculate(Integer.parseInt(br.readLine()));
        }

        System.out.println(sb);
    }


    private static void calculate(int num) {
        if (num > 0) {
            heap.add(num);
        } else {
            sb.append(heap.isEmpty() ? 0 : heap.poll());
            sb.append("\n");
        }
    }
}
