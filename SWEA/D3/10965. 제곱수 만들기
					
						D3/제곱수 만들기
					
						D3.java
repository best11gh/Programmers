import java.util.*;
import java.io.FileInputStream;

class Solution
{
    private static int MAX = 10_000_000;
    private static boolean[] isPrime = new boolean[MAX + 1];
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
                
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int num = sc.nextInt();
            
            int result = getAnswer(num);
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
        
        System.out.println(sb);
	}
    
    private static int getAnswer(int num) {
        int answer = 1;
        
        for (int i = 2; i * i <= num; i++) {
            int cnt = 0;
            
            while (num % i == 0) {
                cnt++;
                num /= i;
            }
            
            if (cnt % 2 == 1){
                answer *= i;
            }
        }
        
        if (num > 1) {
            answer *= num;
        }
        
        return answer;
    }
}