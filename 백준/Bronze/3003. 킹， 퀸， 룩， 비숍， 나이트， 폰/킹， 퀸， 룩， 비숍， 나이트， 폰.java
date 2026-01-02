import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int night = 2;
        int pawn = 8;

        king -= Integer.parseInt(st.nextToken());
        queen -= Integer.parseInt(st.nextToken());
        rook -= Integer.parseInt(st.nextToken());
        bishop -= Integer.parseInt(st.nextToken());
        night -= Integer.parseInt(st.nextToken());
        pawn -= Integer.parseInt(st.nextToken());

        System.out.print(king + " " + queen + " " + rook + " " + bishop + " " + night + " " + pawn);
    }
}
