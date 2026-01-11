import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = N / 5;
        int count = -1;

        for (int i = max; i >= 0; i--) {
            int remain = N - i * 5;

            if (remain % 3 == 0) {
                count = i + (remain / 3);
                break;
            }
        }

        System.out.println(count);
    }
}
