import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();
        
        bw.write(binomialCoefficient(N, K) + "\n");
        bw.flush();
        bw.close();
    }

    private static int binomialCoefficient(int N, int K) {
        if (N == 0 || K == 0 || N == K) {
            return 1;
        }

        return binomialCoefficient(N - 1, K - 1) + binomialCoefficient(N - 1, K);
    }
}
