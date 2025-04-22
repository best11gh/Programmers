import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        int r = 31;
        int M = 1234567891;

        int result = 0;

        String line = br.readLine();
        for (int i = 0; i < L; i++) {
            char str = line.charAt(i);
            int num = str - 'a' + 1;
            result += (int) (num * Math.pow(r, i));
        }

        System.out.println(result % M);
    }
}
