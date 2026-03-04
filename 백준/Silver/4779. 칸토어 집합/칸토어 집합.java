import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num;
        StringBuilder sb = new StringBuilder();
        while ((num = br.readLine()) != null) {
            int N = Integer.parseInt(num);

            String line = "-".repeat((int) Math.pow(3, N));
            sb.append(cantor(line)).append("\n");
        }

        System.out.println(sb);
    }

    private static String cantor(String line) {
        int size = line.length();
        if (size == 1) {
            return "-";
        }

        return cantor(line.substring(0, size / 3)) + " ".repeat(size / 3) + cantor(
                line.substring(size / 3 * 2));
    }
}