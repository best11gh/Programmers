import java.io.*;

public class Main {

    private static int recur = 0;

    private static int[] arr;
    private static int dynamic = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        fib(n);
        fibonacci(n);

        System.out.println(recur + " " + dynamic);
    }


    private static int fib(int n) {
        if (n == 1 || n == 2) {
            recur++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibonacci(int n) {
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            dynamic++;
        }
        return arr[n - 1];
    }
}
