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

            long area = solve(0, n - 1, heights);
            sb.append(area).append("\n");
        }
        System.out.println(sb);
    }

    private static long solve(int left, int right, int[] heights) {
        if (left == right) {
            return heights[left];
        }

        int mid = (left + right) / 2;

        long leftMax = solve(left, mid, heights);
        long rightMax = solve(mid + 1, right, heights);
        long midMax = getMidArea(left, right, mid, heights);

        return Math.max(Math.max(leftMax, rightMax), midMax);
    }

    private static long getMidArea(int left, int right, int mid, int[] heights) {
        int lo = mid;
        int hi = mid + 1;

        long height = Math.min(heights[mid], heights[mid + 1]);
        long maxArea = height * 2;

        while (left < lo || hi < right) {
            if ((left < lo) && (hi == right || (heights[lo - 1] >= heights[hi + 1]))) {
                lo--;
                height = Math.min(height, heights[lo]);
            } else {
                hi++;
                height = Math.min(height, heights[hi]);
            }
            maxArea = Math.max(maxArea, height * (hi - lo + 1));
        }
        return maxArea;
    }
}
