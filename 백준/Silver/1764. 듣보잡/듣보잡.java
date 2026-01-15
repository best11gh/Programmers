import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> notHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }


        List<String> notHeardAndSeen = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (notHeard.contains(name)) {
                notHeardAndSeen.add(name);
            }
        }

        bw.write(Integer.toString(notHeardAndSeen.size()));
        bw.newLine();

        Collections.sort(notHeardAndSeen);
        
        for (String name : notHeardAndSeen) {
            bw.write(name);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
