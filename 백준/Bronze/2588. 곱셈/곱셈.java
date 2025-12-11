import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int one = Integer.parseInt(bf.readLine());
        int two = Integer.parseInt(bf.readLine());

        int three = one * (two % 10);
        int four = one * (two % 100 / 10);
        int five = one * (two / 100);

        int six = one * two;

        System.out.println(three);
        System.out.println(four);
        System.out.println(five);
        System.out.println(six);
    }
}
