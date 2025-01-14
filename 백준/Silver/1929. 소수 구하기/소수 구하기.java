import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] notPrime = new boolean[n + 1];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        notPrime[1] = true;

        for (int i = m; i <= n; i++) {
            if (!notPrime[i]) {
                System.out.println(i);
            }
        }


    }
}