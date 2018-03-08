package dynamicProgramming.problem_11052_붕어빵판매하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11052 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		long[] k = new long[n+1];
		long[] d = new long[n+1];
		String[] data = br.readLine().split(" ");
		
		for(int i=1; i<n+1; i++){
			k[i] = Long.valueOf(data[i-1]);
		}
		System.out.println(solution(k,n,d));
	}
	
	private static long solution(long[] k,int n, long[] d){
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				d[i] = Math.max(d[i], d[i-j]+k[j]);
			}
		}
		return d[n];
	}
}
