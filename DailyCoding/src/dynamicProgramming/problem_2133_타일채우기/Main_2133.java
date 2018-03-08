package dynamicProgramming.problem_2133_타일채우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2133 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] m = new int[n+1];
		System.out.println(getResultData(n,m));
		
	}
	
	private static int getResultData(int n, int[] m){
		
		if(n % 2 != 0)
			return 0;
		m[0] = 1;
		for(int i=2; i<n+1; i=i+2){
			m[i] = 3*m[i-2];
			for(int k=0; k<i-2; k=k+2){
				m[i] += 2*m[k];
			}
			
		}
		return m[n];
	}
}
