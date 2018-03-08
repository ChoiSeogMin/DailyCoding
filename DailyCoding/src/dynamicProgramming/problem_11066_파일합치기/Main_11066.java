package dynamicProgramming.problem_11066_파일합치기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11066 {
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		
		for(int i=0; i<initialNum; i++){
			int j = Integer.valueOf(br.readLine());
			int[] data = new int[j];
			String[] k = br.readLine().split(" ");
			for(int m=0; m<j; m++){
				data[m] = Integer.valueOf(k[m]);
			}
			getSumResult(data);
		}
	}
	
	private static void getSumResult(int[] data){
		
	}
}
