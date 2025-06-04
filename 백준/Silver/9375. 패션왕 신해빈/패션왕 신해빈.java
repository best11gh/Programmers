import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> types = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                types.put(type, types.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            for (int count : types.values()) {
                result *= (count + 1);
            }

            result -= 1;

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}
