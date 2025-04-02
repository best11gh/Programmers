import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> num = new HashMap<>();
        Map<String, Integer> name = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            String input = br.readLine();
            name.put(input, i);
            num.put(i, input);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            try {
                int idx = Integer.parseInt(input);
                sb.append(num.get(idx)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(name.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
