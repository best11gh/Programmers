import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int a = Integer.parseInt(new StringBuilder(A).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(B).reverse().toString());

        int max = Integer.max(a, b);
        System.out.println(max);
    }
}
