import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String n = bf.readLine();
        int N = Integer.parseInt(n);
        int count = n.length();

        int result = 0;

        for (int i = N - count * 9; i < N; i++) {
            int num = i;
            int sum = num;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}