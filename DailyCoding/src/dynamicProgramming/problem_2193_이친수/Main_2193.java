package dynamicProgramming.problem_2193_이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2193 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		long[][] d = new long[n][2];
		System.out.println(solution(d,n));
	}
	/***
	 * d[n][2] 끝이 0일떄 끝이 1일때
	 * @param d
	 * @param n
	 * @return
	 */
	private static long solution(long[][] d, int n){
		//1
		//10
		//101 100
		//1010 1001 1000
		//10101 10100 10010 10001 10000
		d[0][1] = 1;
		if(n==1)
			return 1;
		
		d[1][0] = 1;
		
		for(int i=2; i<n; i++){
			d[i][1] = d[i-1][0];
			d[i][0] = d[i-1][0] +d[i-1][1];
		}
		
		long sum = 0;
		sum += (d[n-1][0] + d[n-1][1]);
		
		return sum;
	}
}
