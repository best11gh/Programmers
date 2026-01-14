import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            if (S.contains(br.readLine())) {
                result++;
            }
        }

        System.out.println(result);
    }
}
