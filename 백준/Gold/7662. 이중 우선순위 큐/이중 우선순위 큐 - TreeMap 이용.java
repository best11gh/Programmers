import java.io.*;
import java.util.*;

// TreeMap 사용
public class Main {
    private static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                calculate(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            if (map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void calculate(String letter, int num) {
        if (letter.equals("I")) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        } else if (!map.isEmpty()) {
            int delNum = num == 1 ? map.lastKey() : map.firstKey();
            if (map.get(delNum) == 1) {
                map.remove(delNum);
            } else {
                map.put(delNum, map.get(delNum) - 1);
            }

        }

    }
}
