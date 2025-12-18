import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int remain = num % 42;
            set.add(remain);
        }

        System.out.println(set.size());
    }
}
