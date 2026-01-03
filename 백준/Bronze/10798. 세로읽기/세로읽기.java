import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                arr[i][j] = word.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                char ch = arr[j][i];
                if (ch == '\0') continue;
                System.out.print(ch);
            }
        }

    }
}
