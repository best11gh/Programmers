import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    
    private static int N;
    private static int L;
    private static int[][] arr; 
    private static int max;
    
	public static void main(String args[]) throws Exception
	{
        
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            L = sc.nextInt();
            
            arr = new int[N][2];
            max = 0;
            
            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            
            dfs(0, 0, 0);
            
            System.out.println("#" + test_case + " " + max);
		}
	}
    
    private static void dfs(int start, int score, int cal) {
        if (cal > L) {
            return;
        }
        
        max = Math.max(max, score);
        
        for (int i = start; i < N; i++) {
            dfs(i+1, score + arr[i][0], cal + arr[i][1]);
        }
    }
}