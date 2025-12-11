import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int y = Integer.parseInt(bf.readLine());
        System.out.println(y - 543);
    }
}
