import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String number = bf.readLine();

            if (number.equals("0")) {
                break;
            }

            boolean isPalindrome = true;

            for (int i = 0; i <= number.length() / 2; i++) {
               if (number.charAt(i) != number.charAt(number.length() -1 -i)){
                   System.out.println("no");
                   isPalindrome = false;
                   break;
               }
            }

            if (isPalindrome){
                System.out.println("yes");
            }

        }
    }
}