import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            bw.write(" ".repeat(n - i) + "*".repeat(2 * i - 1));
            bw.newLine();
        }

        for (int i = n - 1; i >= 1; i--) {
            bw.write(" ".repeat(n - i) + "*".repeat(2 * i - 1));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
