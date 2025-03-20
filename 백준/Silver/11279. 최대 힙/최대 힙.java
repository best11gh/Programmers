import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            calculate(Integer.parseInt(br.readLine()));
        }

        System.out.println(sb);
    }


    private static void calculate(int x) {
        if (x == 0) {
            sb.append(maxHeap.isEmpty() ? 0 : maxHeap.poll()).append("\n");
        } else {
            maxHeap.add(x);
        }

    }
}
