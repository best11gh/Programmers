import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001]; 
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            count[num + 4000]++; 
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int avg = (int) Math.round((double) sum / N);
        bw.write(avg + "\n");

        Arrays.sort(arr);
        int median = arr[N / 2];
        bw.write(median + "\n");

        int mode = 0;
        int modeMax = 0;
        boolean second = false; 

        for (int i = 0; i < 8001; i++) {
            if (count[i] > modeMax) {
                modeMax = count[i];
                mode = i - 4000;
                second = false; 
            } else if (count[i] == modeMax && !second) {
                mode = i - 4000;
                second = true; 
            }
        }
        bw.write(mode + "\n");

        int range = max - min;
        bw.write(range + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
