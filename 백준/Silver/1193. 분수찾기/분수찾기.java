import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        // 몇 번째 대각선인지 찾기
        int n = 1;
        while (n * (n + 1) / 2 < X) {
            n++;
        }

        // 대각선에서의 위치
        int position = X - (n - 1) * n / 2;

        if (n % 2 == 0) {
            System.out.println(position + "/" + (n - position + 1));
        } else {
            System.out.println((n - position + 1) + "/" + position);
        }
    }
}
