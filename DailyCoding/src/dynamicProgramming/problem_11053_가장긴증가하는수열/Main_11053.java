package dynamicProgramming.problem_11053_가장긴증가하는수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[n];
		int[] m = new int[n];
		int i = 0;;
		while(st.hasMoreTokens()){
			data[i++] = Integer.valueOf(st.nextToken(" "));
		}
		System.out.println(getResult(data,m));
	}
	
	private static int getResult(int[] data, int[] m){
		m[0] = 1;
		for(int i=1; i<data.length; i++){
			m[i] = 1;
			for(int j=i-1; j>=0; j--){
				if(data[i]>data[j]){
					m[i] = Math.max(m[i],m[j] + 1);
				}
			}
		}
		int result = 0;
		for(int i=0; i<data.length; i++){
			result = Math.max(result, m[i]);
		}
		return result;
	}
}
