import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            xs.add(Integer.parseInt(st.nextToken()));
            ys.add(Integer.parseInt(st.nextToken()));
        }

        int minX = Collections.min(xs);
        int maxX = Collections.max(xs);

        int minY = Collections.min(ys);
        int maxY = Collections.max(ys);

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
