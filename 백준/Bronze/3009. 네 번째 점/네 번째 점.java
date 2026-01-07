import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] xs = new int[3];
        int[] ys = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        int x = findUnique(xs[0], xs[1], xs[2]);
        int y = findUnique(ys[0], ys[1], ys[2]);

        System.out.println(x + " " + y);

    }

    private static int findUnique(int a, int b, int c) {
        return (a == b) ? c : (a == c) ? b : a;
    }
}
