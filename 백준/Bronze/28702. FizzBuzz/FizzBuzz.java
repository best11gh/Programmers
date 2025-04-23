import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -1;

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if (isNumber(str)) {
                answer = Integer.parseInt(str) + 3 - i;
                break;
            }

        }

        System.out.println(fizzBuss(answer));
    }


    private static boolean isNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private static String fizzBuss(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}
