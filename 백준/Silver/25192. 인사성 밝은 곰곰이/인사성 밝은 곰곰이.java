import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> people = new HashSet<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.equals("ENTER")) {
                people.clear();
                continue;
            }

            if (people.add(line)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
