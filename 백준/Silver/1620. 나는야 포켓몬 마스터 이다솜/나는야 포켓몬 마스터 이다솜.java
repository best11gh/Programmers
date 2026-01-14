import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameKey = new HashMap<>();
        String[] numberKey = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String key = br.readLine();
            nameKey.put(key, i);
            numberKey[i] = key;
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                bw.write(numberKey[Integer.parseInt(question)]);
            } else {
                bw.write(String.valueOf(nameKey.get(question)));
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
