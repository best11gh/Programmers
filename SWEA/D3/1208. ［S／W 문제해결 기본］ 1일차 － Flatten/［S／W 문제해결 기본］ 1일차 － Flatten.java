import java.util.*;
import java.io.FileInputStream;

class Solution
{
    
    private static int WIDTH = 100;
    
    private static int dump;
    private static int[] boxes;
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            dump = sc.nextInt();
            
            boxes = new int[WIDTH];
            for (int i = 0; i < WIDTH; i++) {
                boxes[i] = sc.nextInt();
            }

            Arrays.sort(boxes);
                        
            dfs(0);
            int result = boxes[WIDTH - 1] - boxes[0];
            System.out.println("#" + test_case + " " + result);
		}
	}
        
    private static void dfs(int cnt) {
        if (cnt == dump) {
            return;
        }
        
        if (boxes[WIDTH - 1] - boxes[0] <= 1) {
            return;
        }
        
        boxes[0]++;
        boxes[WIDTH - 1]--;
        
        Arrays.sort(boxes);

        dfs(cnt+1);
    }
}