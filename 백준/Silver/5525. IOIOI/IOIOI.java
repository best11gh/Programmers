import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String pn = "I";

        pn += "OI".repeat(N);

        int count = 0;
        int index = 0;

        while ((index = S.indexOf(pn, index)) != -1) {
            count++;
            index++;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
