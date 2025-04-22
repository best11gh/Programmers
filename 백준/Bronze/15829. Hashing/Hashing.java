import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        int r = 31;
        int M = 1234567891;

        String line = br.readLine();
        long result = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            int num = line.charAt(i) - 'a' + 1;
            result += num * pow;
            pow = pow * r % M;
        }

        System.out.println(result % M);
    }
}
