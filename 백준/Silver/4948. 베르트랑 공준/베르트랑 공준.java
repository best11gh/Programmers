import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            int primeCount = getPrimeCount(num);
            bw.write(Integer.toString(primeCount));
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static int getPrimeCount(int num) {
        int count = 0;
        for (int i = num + 1; i <= 2 * num; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
