import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int S = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if (type.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                bw.write((check(num) ? "1" : "0") + "\n");
            } else {
                switch (type) {
                    case "add":
                        int addNum = Integer.parseInt(st.nextToken());
                        add(addNum);
                        break;
                    case "remove":
                        int removeNum = Integer.parseInt(st.nextToken());
                        remove(removeNum);
                        break;
                    case "toggle":
                        int toggleNum = Integer.parseInt(st.nextToken());
                        toggle(toggleNum);
                        break;
                    case "all":
                        all();
                        break;
                    case "empty":
                        empty();
                        break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void add(int x) {
        S |= (1 << (x - 1));
    }

    private static void remove(int x) {
        S &= ~(1 << (x - 1));
    }

    private static boolean check(int x) {
        return (S & (1 << (x - 1))) > 0;
    }

    private static void toggle(int x) {
        S ^= (1 << (x - 1));
    }

    private static void all() {
        S = (1 << 20) - 1;
    }

    private static void empty() {
        S = 0;
    }
}
