import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] coordinates = new int[N];
        int[] sortCoordinates = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            coordinates[i] = x;
            sortCoordinates[i] = x;
        }

        Arrays.sort(sortCoordinates);
        HashMap<Integer, Integer> rank = new HashMap<>();

        int idx = 0;
        for (int coordinate : sortCoordinates) {
            if (!rank.containsKey(coordinate)){
                rank.put(coordinate, idx);
                idx++;
            }
        }

        for (int coordinate : coordinates) {
            int coordRank = rank.get(coordinate);
            bw.write(coordRank + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
