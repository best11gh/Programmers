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
            int n = sc.nextInt();
          
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                prices[i] = num;
            }

            long profit = getProfit(prices);
            System.out.println("#" + test_case + " " + profit);
		}
	}
    
    private static long getProfit(int[] prices) {
        int max = 0;
        long totalProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            int price = prices[prices.length - i - 1];

            max = Math.max(max, price);
            totalProfit += max -price;
        }
        return totalProfit;
    }
}