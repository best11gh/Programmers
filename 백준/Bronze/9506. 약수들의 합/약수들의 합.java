import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }

            List<Integer> factors = getFactors(n);

            if (isPerfectNum(n, factors)) {
                sb.append(n).append(" = ");
                StringJoiner joiner = new StringJoiner(" + ");
                for (Integer factor : factors) {
                    joiner.add(String.valueOf(factor));
                }
                sb.append(joiner);
            } else {
                sb.append(n).append(" is NOT perfect.");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static List<Integer> getFactors(int num) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isPerfectNum(int num, List<Integer> factors) {
        int sum = 0;
        for (Integer factor : factors) {
            sum += factor;
        }

        return num == sum;
    }
}
