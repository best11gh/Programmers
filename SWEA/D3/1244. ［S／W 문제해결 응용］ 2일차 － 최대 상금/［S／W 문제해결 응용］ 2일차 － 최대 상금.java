import java.util.*;
import java.io.FileInputStream;

class Solution
{
    
    private static int target;
    private static int length;
    private static int max;
    private static boolean[][] visited;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String num = sc.next();
            target = sc.nextInt();
           
            length = num.length();
            max = 0;
            visited = new boolean[target + 1][1000000];
            
            dfs(num, 0);

            System.out.println("#" + test_case + " " + max);
		}
	}
    
    private static void dfs(String num, int cnt) {
        int current = Integer.parseInt(num);
        if (visited[cnt][current]) {
            return;
        }
        
        visited[cnt][current] = true;
        
        if (cnt == target) {
            max = Math.max(max, current);
            return;
        }
        
      for (int i = 0; i < length; i++) {
          for (int j = i + 1; j < length; j++) {
              String result = swap(num, i, j);
              dfs(result, cnt + 1);
          }
      }
    }

    private static String swap(String num, int idx1, int idx2) {
        char[] arr = num.toCharArray();
        
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        
        return new String(arr);
    }
}