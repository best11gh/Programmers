import java.io.*;
import java.util.*;

// queue 두 개 사용
public class Main {
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static final HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            minHeap.clear();
            maxHeap.clear();
            map.clear();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                calculate(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int res = delete(maxHeap);
                sb.append(res).append(" ");
                if (!map.isEmpty()) {
                    res = delete(minHeap);
                }
                sb.append(res).append("\n");
            }
        }

        System.out.println(sb);
    }


    private static void calculate(String letter, int num) {
        if (letter.equals("I")) {
            minHeap.add(num);
            maxHeap.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        } else if (!map.isEmpty()) {
            delete(num == 1 ? maxHeap : minHeap);
        }
    }


    private static int delete(PriorityQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (map.containsKey(num)) {
                int cnt = map.getOrDefault(num, 0);
                if (cnt == 1) {
                    map.remove(num);
                } else {
                    map.put(num, cnt - 1);
                }
                return num;
            }
        }
        return 0;
    }
}
