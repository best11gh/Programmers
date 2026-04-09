import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine() + "+";

        int result = 0;
        boolean plus = true;
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '+' || ch == '-') {
                if (plus) {
                    result += Integer.parseInt(num.toString());
                } else {
                    result -= Integer.parseInt(num.toString());
                }

                num.setLength(0);
                if (ch == '-') {
                    plus = false;
                }
            } else {
                num.append(ch);
            }
        }

        System.out.println(result);
    }
}
