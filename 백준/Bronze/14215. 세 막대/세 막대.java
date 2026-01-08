import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;
        int max = Integer.max(a, Integer.max(b, c));

        if (sum - max > max) {
            System.out.println(a + b + c);
        } else {
            System.out.println((sum - max) * 2 - 1);
        }
    }
}
