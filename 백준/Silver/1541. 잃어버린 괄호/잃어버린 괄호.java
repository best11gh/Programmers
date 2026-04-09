import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = 0;
        boolean isFirst = true;

        while (st.hasMoreTokens()) {
            String line = st.nextToken();
            StringTokenizer plus = new StringTokenizer(line, "+");

            int sum = 0;
            while (plus.hasMoreTokens()) {
                sum += Integer.parseInt(plus.nextToken());
            }

            if (isFirst) {
                result += sum;
                isFirst = false;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
