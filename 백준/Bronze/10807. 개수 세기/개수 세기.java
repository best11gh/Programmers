import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums.add(num);
        }

        int v = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int x : nums){
            if (x == v){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
