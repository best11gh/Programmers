import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Word> words = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            words.add(new Word(br.readLine()));
        }

        for (Word word : words) {
            System.out.println(word.text);
        }
    }


    private static class Word implements Comparable<Word> {
        final String text;

        private Word(String text) {
            this.text = text;
        }

        @Override
        public int compareTo(Word o) {
            if (this.text.length() != o.text.length()){
                return this.text.length() - o.text.length();
            }
            return this.text.compareTo(o.text);
        }


    }
}
