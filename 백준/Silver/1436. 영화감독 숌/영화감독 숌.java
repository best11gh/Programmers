import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int number = 666;

        while (true) {
            if (String.valueOf(number).contains("666")) {
                cnt++;
                if (cnt == N) {
                    bw.write(number + "\n");
                    break;
                }
            }
            number++; 
        }

        bw.flush();
        bw.close();
        br.close();
    }
}