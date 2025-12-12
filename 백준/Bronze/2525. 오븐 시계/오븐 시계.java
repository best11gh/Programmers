import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int addH = c / 60;
        int addM = c % 60;
        a+=addH;

        if (b + addM > 59) {
            a++;
            b = b + addM - 60;
        } else {
            b += addM;
        }

        if (a > 23) {
            a -= 24;
        }

        System.out.println(a + " " + b);
    }
}
