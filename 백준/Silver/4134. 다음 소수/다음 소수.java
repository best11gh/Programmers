import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        for (int i = 0; i < N; i++) {
            long prime = Long.parseLong(br.readLine());

            while (!isPrime(prime)) {
                prime++;
            }

            bw.write(Long.toString(prime));
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
