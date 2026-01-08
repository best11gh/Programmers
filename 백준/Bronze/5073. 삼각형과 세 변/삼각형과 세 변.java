import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int max = Math.max(a, Math.max(b, c));

            if ((a + b + c) - max <= max) {
                sb.append("Invalid");
            } else if (a == b && a == c) {
                sb.append("Equilateral");
            } else if (a == b || a == c || b == c) {
                sb.append("Isosceles");
            } else {
                sb.append("Scalene");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
