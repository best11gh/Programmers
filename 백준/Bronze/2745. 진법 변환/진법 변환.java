import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int result = 0;
        int temp = 1;

        for (int i = N.length() - 1; i >= 0; i--) {
            char ch = N.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (ch - 'A' + 10) * temp;
            } else {
                result += (ch - '0') * temp;
            }

            temp *= B;
        }

        System.out.println(result);
    }
}
