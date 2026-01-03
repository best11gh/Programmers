import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (checkGroup(word)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean checkGroup(String word) {
        String left = "";
        Set<String> words = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            String ch = String.valueOf(word.charAt(i));

            if (!left.equals(ch)) {
                if (words.contains(ch)) {
                    return false;
                }

                left = ch;
                words.add(ch);
            }
        }
        return true;
    }
}
