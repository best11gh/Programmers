import java.io.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((int) Math.pow(2, N) - 1);
        hanoi(N, 1, 3, 2);
        System.out.println(sb);
    }

    private static void hanoi(int count, int startCol, int endCol, int tempCol) {
        if (count == 1) {
            sb.append(startCol).append(" ").append(endCol).append("\n");
            return;
        }

        hanoi(count - 1, startCol, tempCol, endCol);
        sb.append(startCol).append(" ").append(endCol).append("\n");
        hanoi(count - 1, tempCol, endCol, startCol);
    }
}
