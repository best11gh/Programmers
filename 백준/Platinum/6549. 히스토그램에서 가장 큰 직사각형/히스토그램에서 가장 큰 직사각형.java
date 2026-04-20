import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);

            int n = Integer.parseInt(st.nextToken());
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            long area = solve(heights);
            sb.append(area).append("\n");
        }
        System.out.println(sb);
    }

    private static long solve(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        long maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int current = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && (heights[stack.peek()] > current)) {
                int idx = stack.pop();

                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long height = heights[idx];

                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
