import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int gcd = getGcd(A, B);
            bw.write(Integer.toString((A * B / gcd)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static int getGcd(int a, int b) {
        while (b > 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

}
