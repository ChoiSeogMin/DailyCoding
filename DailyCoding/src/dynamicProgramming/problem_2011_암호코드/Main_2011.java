package dynamicProgramming.problem_2011_암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_2011 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] data = br.readLine().toCharArray();
		long[] m = new long[data.length];
		System.out.println(getPossibleCount(data,m));
	}
	
	private static long getPossibleCount(char[] data,long[] m){
		
		int f = data[0] - '0';
	
		if(f == 0)
			return 0;
		else
			m[0] = 1;		
	
		for(int i=1; i<data.length; i++){
			int k = data[i] - '0';
			
			if(k<=9 && k>=1){
					m[i] += m[i-1];
					m[i] %= 1000000;
			}
			if(i==1){
				int o =  (data[i-1] - '0')* 10 + k;
				if(o==10 || o==20){
					m[1] = 1;
					continue;
				}
				
				if(10<=o && o<=26){ //11~26 20빼고 
					m[1] = 2;
					continue;
				}
			}
			
			int j = (data[i-1] - '0') * 10 + k;
			
			if(10<=j && j<=26){
				m[i] += m[i-2];
				m[i] %= 1000000;
			}
			
		}
		return m[data.length-1];
	}
}
