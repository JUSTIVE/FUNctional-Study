import java.io.*;
import java.util.Scanner;

public class Main {
	public static long solution(int n) {
		long answer = 0;
		long[] dp = new long[81];
        dp [0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
       
		answer = 2 * (dp[n] + dp[n-1]) + 2 * (dp[n]);
        
		
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long result = solution(n);
		System.out.println(result);
	}
}