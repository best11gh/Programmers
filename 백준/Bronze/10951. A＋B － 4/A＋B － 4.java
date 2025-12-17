import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (st.countTokens() < 2) break;

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(a + b));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
