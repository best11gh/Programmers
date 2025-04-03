import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        sb.append("<");

        int index = 0;
        while (!people.isEmpty()) {
            index = (index + K - 1) % people.size();
            sb.append(people.remove(index));
            if (!people.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb);
        br.close();
    }
}
