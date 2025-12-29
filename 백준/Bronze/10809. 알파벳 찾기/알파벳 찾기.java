import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] result = new int[26];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (result[ch - 'a'] == -1) {
                result[ch - 'a'] = i;
            }
        }

        for (int res: result) {
            System.out.print(res + " ");
        }
    }
}
