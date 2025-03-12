import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // PN에서 OI의 개수
        int M = Integer.parseInt(br.readLine()); // 문자열 S의 길이
        String S = br.readLine();

        int count = 0; // PN의 개수를 셀 변수
        int pattern = 0; // 'OI' 패턴의 연속 횟수

        for (int i = 0; i < M - 1; i++) {
            // 'I'로 시작하는 경우만 패턴 검사
            if (S.charAt(i) == 'I') {
                // 연속된 'OI'의 개수를 확인
                while (i + 1 < M && S.charAt(i + 1) == 'O' && i + 2 < M && S.charAt(i + 2) == 'I') {
                    pattern++; // 'OI'가 나올 때마다 증가
                    i += 2; // 'OI' 검사했으므로 두 칸 이동

                    // N번의 'OI'가 연속되면 PN 패턴 완성
                    if (pattern == N) {
                        count++; 
                        pattern--; // 중복되는 부분을 유지하기 위해 감소
                    }
                }
                // 'OI' 패턴이 끊기면 초기화
                pattern = 0;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
