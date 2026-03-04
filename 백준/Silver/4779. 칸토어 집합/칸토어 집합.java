import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num;
        StringBuilder sb = new StringBuilder();
        while ((num = br.readLine()) != null) {
            int N = Integer.parseInt(num);
            sb.append(cantor(N)).append("\n");
        }

        System.out.println(sb);
    }

    private static String cantor(int n) {
        if (n == 0) {
            return "-";
        }

        String prev = cantor(n - 1);
        String space = " ".repeat(prev.length());

        return prev + space + prev;
    }
}
