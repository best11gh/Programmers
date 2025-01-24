import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int count = N / 5 + 1;
        int result = Integer.MAX_VALUE;

        for (int i = count - 1; i >= 0; i--) {
            int remain = N - (5 * i);
            if (remain % 3 == 0) {
                result = Math.min(result, remain / 3 + i);
            }
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
