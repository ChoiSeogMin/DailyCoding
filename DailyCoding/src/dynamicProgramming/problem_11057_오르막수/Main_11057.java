package dynamicProgramming.problem_11057_오르막수;

import java.util.Scanner;

public class Main_11057 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[][] = new int[n][10];
		System.out.println(getResultValue(n,d));
		
	}
	
	private static long getResultValue(int n, int d[][]){
		
		for(int i=0; i<10; i++)
			d[0][i] = 1;// 0~9 까지 1셋팅
		
		
		for(int j=1; j<n; j++){
			for(int k=0; k<10; k++){
				for(int i=k; i>=0; i--){
					d[j][k] += d[j-1][i]; 
				}
				
				d[j][k] %= 10007;
			}
		}
		
		
		long sum = 0;
		for(int i=0; i<10; i++)
			sum += d[n-1][i];
		
		
		return sum % 10007;
	}
}
