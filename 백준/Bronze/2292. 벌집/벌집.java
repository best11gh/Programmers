import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int count = 1;

        int checking = 1;
        int addNumber = 6;

        while (checking < N) {
            checking += addNumber;
            count += 1;
            addNumber += 6;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        

    }
}
