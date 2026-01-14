import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> user = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            if (log.equals("enter")) {
                user.add(name);
            } else {
                user.remove(name);
            }
        }

        List<String> result = new ArrayList<>(user);
        result.sort(Collections.reverseOrder());

        for (String name : result) {
            bw.write(name);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
