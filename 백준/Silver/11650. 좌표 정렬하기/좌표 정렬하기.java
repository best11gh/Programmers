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

        Coordinate[] arr = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Coordinate(x, y);
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i].toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static class Coordinate implements Comparable<Coordinate> {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }

            return this.x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }


}
