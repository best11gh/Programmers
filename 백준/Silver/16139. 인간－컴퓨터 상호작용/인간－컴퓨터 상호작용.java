import java.io.*;
import java.util.*;

public class Main {

    private static final int ALPHABET_CNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int q = Integer.parseInt(br.readLine());
        int[][] cnt = new int[S.length() + 1][ALPHABET_CNT];

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j < ALPHABET_CNT; j++) {
                cnt[i][j] += cnt[i - 1][j];
            }
            
            char ch = S.charAt(i - 1);
            cnt[i][ch - 'a'] = cnt[i - 1][ch - 'a'] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int result = cnt[end + 1][ch - 'a'] - cnt[start][ch - 'a'];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
