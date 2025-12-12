import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());
        int result = 0;

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            result = 1;
        }

        System.out.println(result);
    }
}