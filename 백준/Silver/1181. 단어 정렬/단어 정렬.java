import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<Word> words = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            words.add(new Word(br.readLine()));
        }

        for (Word word : words) {
            bw.write(String.valueOf(word.value));
            bw.newLine();
        };

        bw.close();
        br.close();
    }

    private static class Word implements Comparable<Word> {
        String value;

        public Word(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(Word o) {
            if (o.value.length() == this.value.length()) {
                return this.value.compareTo(o.value);
            }
            return this.value.length() - o.value.length();
        }
    }
}
