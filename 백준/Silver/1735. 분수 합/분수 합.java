import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aNumerator = Integer.parseInt(st.nextToken());
        int aDenominator = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int bNumerator = Integer.parseInt(st.nextToken());
        int bDenominator = Integer.parseInt(st.nextToken());


        int numeratorSum = aNumerator * bDenominator + bNumerator * aDenominator;
        int denominator = aDenominator * bDenominator;

        int gcd = getGcd(numeratorSum, denominator);

        System.out.println((numeratorSum / gcd) + " " + (denominator / gcd));
    }

    private static int getGcd(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
