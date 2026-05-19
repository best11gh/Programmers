import java.util.*;
import java.io.FileInputStream;

class Solution
{
    
    private static int N;
    private static int M;
    private static int[][] arr;
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            M = sc.nextInt();
            
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
  
            int result = getMax();
            System.out.println("#" + test_case + " " + result);
		}
	}
    
    private static int getMax() {
        int max = 0;
        
        for (int i = 0; i < N - M + 1; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                int sum = getCount(i, j);
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
    
    private static int getCount(int row, int col) {
        int sum = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sum += arr[row + i][col + j];
            }
        }
        
        return sum;
    }
}