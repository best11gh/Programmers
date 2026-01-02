import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        List<String> alphabet = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
        for (String str : alphabet) {
            word = word.replace(str, "#");
        }

        System.out.println(word.length());
    }
}
