import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());

        int gcd = getGcd(number1, number2);
        int lcm = getLcm(number1, number2, gcd);

        bw.write(gcd + "\n");
        bw.write(lcm + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int remain = 0;
            remain = a % b;
            a = b;
            b = remain;
        }

        return a;
    }

    private static int getLcm(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
