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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] calSum = new int[N + 1];
        calSum[0] = 0;
        st = new StringTokenizer(br.readLine());
        int tempSum = 0;
        for (int i = 1; i < N + 1; i++) {
            tempSum += Integer.parseInt(st.nextToken());
            calSum[i] = tempSum;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int result = calSum[num2] - calSum[num1 - 1];
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
