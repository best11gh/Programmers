import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String vps = br.readLine();
            long countLeft = vps.chars().filter(ch -> ch == '(').count();
            long countRight = vps.chars().filter(ch -> ch == ')').count();
            if (countLeft != countRight) {
                bw.write("NO" + "\n");
                continue;
            }

            bw.write((checkVps(vps) ? "YES" : "NO") + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean checkVps(String vps) {
        Stack<Character> stack = new Stack<>();

        for (char ch : vps.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
