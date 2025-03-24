import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> notHeard = new HashSet<>();

        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String notSeen = br.readLine();
            if (notHeard.contains(notSeen)){
                result.add(notSeen);
            }
        }

        Collections.sort(result);

        sb.append(result.size() + "\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
