import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        // a 개수 세기
        int a_len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (hasChar(i, 'a')) {
                a_len++;
            }
        }

        int result = a_len;

        for (int i = 0; i < str.length(); i++) {
            int b_len = 0;
            for (int j = i; j < i + a_len; j++) {
                if (hasChar(j % str.length(), 'b')) {
                    b_len++;
                }
            }
            result = Math.min(result, b_len);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean hasChar(int index, char ch) {
        return str.charAt(index) == ch;

    }
}
