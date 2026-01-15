import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> aNumbers = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aNumbers.add(Integer.parseInt(st.nextToken()));
        }

        int aOnly = A;
        int bOnly = B;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (aNumbers.contains(num)) {
                aOnly--;
                bOnly--;
            }
        }

        System.out.println(aOnly + bOnly);
    }
}
