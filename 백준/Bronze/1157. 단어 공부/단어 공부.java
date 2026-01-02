import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        word = word.toUpperCase();

        int[] cnts = new int[26];

        for (char ch : word.toCharArray()) {
            cnts[ch - 'A']++;
        }

        int max = 0;
        char ch = '?';
        for (int i = 0; i < cnts.length; i++) {
            int num = cnts[i];

            if (num > max) {
                ch = (char) (i + 'A');
                max = num;
            } else if (num == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
