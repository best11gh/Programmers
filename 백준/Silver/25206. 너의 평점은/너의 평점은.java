import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalScore = 0;
        double total = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            totalScore += score;
            total += score * getScore(grade);
        }

        System.out.println(total/totalScore);
    }

    private static double getScore(String grade) {
        double result = 0.0;
        switch (grade) {
            case "A+":
                result = 4.5;
                break;

            case "A0":
                result = 4.0;
                break;

            case "B+":
                result = 3.5;
                break;

            case "B0":
                result = 3.0;
                break;
            case "C+":
                result = 2.5;
                break;
            case "C0":
                result = 2.0;
                break;
            case "D+":
                result = 1.5;
                break;
            case "D0":
                result = 1.0;
                break;
            case "F":
                result = 0.0;
                break;
        }

        return result;
    }
}
