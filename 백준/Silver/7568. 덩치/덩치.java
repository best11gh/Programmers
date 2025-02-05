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

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people[i][0] = x;
            people[i][1] = y;
        }

        for (int[] person1 : people) {
            int count = 1;
            for (int[] person2 : people) {
                if ((person1[0] < person2[0]) && (person1[1] < person2[1])) {
                    count++;
                }
            }
            bw.write(count + " ");
        }

        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
