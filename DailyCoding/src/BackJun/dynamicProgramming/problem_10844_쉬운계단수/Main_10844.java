package dynamicProgramming.problem_10844_쉬운계단수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		long[][] d = new long[initialNum][10];
		System.out.println(solution(initialNum,d));
	}
	private static long solution(int n,long[][] d){
		
		//intialD 
		//d[i] 는 끝의수
		for(int i=1; i<=9; i++){
			d[0][i] = 1; //1 ~ 9 까지 
		}
		
		for(int i=0; i<n-1; i++){
			for(int j=0; j<=9; j++){
				if(j==0){
					d[i+1][j] = d[i][j+1] % 1000000000L;
				}else if(j==9){
					d[i+1][j] = d[i][j-1] % 1000000000L;
				}else{
					d[i+1][j] = (d[i][j-1]+d[i][j+1]) % 1000000000L;
				}
			}
		}
		
		//아 합계할떄 long으로 안해서 2번 더 틀림.. 
		long sum = 0;
		for(int i=0; i<10; i++){
			sum += d[n-1][i] ;
		}
		return sum%1000000000L;
	}
}
