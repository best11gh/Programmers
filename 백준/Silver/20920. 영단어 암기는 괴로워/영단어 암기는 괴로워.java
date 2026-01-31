import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }

            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        List<String> names = new ArrayList<>(words.keySet());

        Collections.sort(names, (a, b) -> {
            if (!words.get(a).equals(words.get(b))) {
                return words.get(b) - words.get(a);
            }

            if (a.length() != b.length()) {
                return b.length() - a.length();
            }

            return a.compareTo(b);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
