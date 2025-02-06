import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int result = 0;
        for (int i = 0; i < N; i++) {
            int[] tempTimes = Arrays.copyOf(times, i + 1);
            int personal = calculateTime(tempTimes, tempTimes.length - 1);
            result += personal;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int calculateTime(int[] times, int idx) {
        if (idx == 0) {
            return times[0];
        }

        return calculateTime(times, idx - 1) + times[idx];
    }

}
