import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int money = 0;

        if (a == b && b == c) {
            money = 10000 + a * 1000;
        } else if (a == b || a == c) {
            money = 1000 + a * 100;
        } else if (b == c) {
            money = 1000 + b * 100;
        } else {
            money = Math.max(Math.max(a, b), c) * 100;
        }

        System.out.println(money);
    }
}
