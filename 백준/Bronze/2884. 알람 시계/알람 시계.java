import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int earlyMinute = 45;

        if (m - earlyMinute < 0) {
            h--;
            m = m + 60 - 45;
            if (h < 0) {
                h += 24;
            }
        } else {
            m -= 45;
        }

        System.out.println(h + " " + m);

    }
}
