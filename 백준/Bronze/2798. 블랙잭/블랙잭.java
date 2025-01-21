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
        int[] nums = new int[N];
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int result = getResult(N, nums, M);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int getResult(int N, int[] nums, int M) {
        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            if (nums[i] > M) {
                continue;
            }
            for (int j = i + 1; j < N - 1; j++) {
                if (nums[i] + nums[j] > M) {
                    continue;
                }
                for (int k = j + 1; k < N; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > M) {
                        continue;
                    }
                    if (sum == M) {
                        return M;
                    }

                    result = Math.max(sum, result);
                }
            }
        }
        return result;
    }
}
