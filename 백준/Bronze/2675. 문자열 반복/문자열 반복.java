import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            for (char ch : S.toCharArray()) {
                sb.append(String.valueOf(ch).repeat(R));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
