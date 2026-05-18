import java.util.*;
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
            int tc = sc.nextInt();
            
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 1000; i++) {
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int maxCnt = 0;
            int mode = 0;

            for (int i = 0; i <= 100; i++) {
                int count = map.getOrDefault(i, 0);
                if (count >= maxCnt) {
                    maxCnt = count;
                    mode = i;
                }
            }

            System.out.println("#" + tc + " " + mode);
		}
	}
}