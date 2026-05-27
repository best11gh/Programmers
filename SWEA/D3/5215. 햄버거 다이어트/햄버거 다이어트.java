import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int L = sc.nextInt();
            
            int[] dp = new int[L + 1];
            
            for (int i = 1; i <= N; i++) {
                int score = sc.nextInt();
                int cal = sc.nextInt();
                
                for (int j = L; j >= cal; j--) {
                    dp[j] = Math.max(dp[j], dp[j - cal] + score);
                }
            }
            System.out.println("#" + test_case + " " + dp[L]);
		}
	}
}