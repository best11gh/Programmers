import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> students = new ArrayList<>();
        for (int i = 1; i <= 30; i++){
            students.add(i);
        }

        for (int i = 0; i < 28; i++) {
            Integer num = Integer.parseInt(br.readLine());
            students.remove(num);
        }

        Collections.sort(students);
        System.out.println(students.get(0));
        System.out.println(students.get(1));
    }
}
