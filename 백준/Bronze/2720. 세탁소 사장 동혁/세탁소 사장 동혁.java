import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            result.append(getResult(Integer.parseInt(br.readLine())));
            result.append("\n");
        }
        System.out.println(result);
    }


    private static String getResult(int change) {
        int QUARTER = 25;
        int DIME = 10;
        int NICKEL = 5;
        int PENNY = 1;

        StringBuilder sb = new StringBuilder();

        sb.append(change / QUARTER).append(" ");
        change %= QUARTER;

        sb.append(change / DIME).append(" ");
        change %= DIME;

        sb.append(change / NICKEL).append(" ");
        change %= NICKEL;

        sb.append(change / PENNY).append(" ");
        change %= PENNY;

        return sb.toString();
    }
}
