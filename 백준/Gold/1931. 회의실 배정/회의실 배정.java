import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Meet[] meets = new Meet[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meets[i] = new Meet(start, end);
        }

        Arrays.sort(meets);

        int result = 0;
        int lastEndTime = 0;

        for (Meet meet : meets) {
            if (lastEndTime <= meet.start) {
                result++;
                lastEndTime = meet.end;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    private static class Meet implements Comparable<Meet> {
        private final int start;
        private final int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }
}
