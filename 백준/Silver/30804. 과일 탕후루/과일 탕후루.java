import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < N; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

            while (count.size() > 2) {
                int leftFruit = fruits[left];

                count.put(leftFruit, count.get(leftFruit) - 1);

                if (count.get(leftFruit) == 0) {
                    count.remove(leftFruit);
                }

                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }
}
