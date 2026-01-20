import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 1_000_000;
    private static boolean[] isPrime; // 소수 => true

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        isPrime = new boolean[MAX + 1];
        makeShifter();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(Integer.toString(countPartition(num)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static int countPartition(int num) {
        int count = 0;

        if (num == 4) {
            return 1;
        }

        for (int i = 3; i <= num / 2; i += 2) {
            if (isPrime[i] && isPrime[num - i]) {
                count++;
            }
        }
        return count;
    }


    private static void makeShifter() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (!isPrime[i]) { // 합성수이면 패스
                continue;
            }

            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }
}
