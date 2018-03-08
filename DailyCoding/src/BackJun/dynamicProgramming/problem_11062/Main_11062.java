package dynamicProgramming.problem_11062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11062 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<initialNum; i++){
			int n = Integer.valueOf(br.readLine());
			int[] nums = new int[n];
			String[] data = br.readLine().split(" ");
			
			for(int j=0; j<data.length; j++){
				nums[j] = Integer.valueOf(data[j]);
			}
			sb.append(getResultNum(nums)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int getResultNum(int[] data){
		
		int sum = 0;
		int j = 0;
		int i = data.length -1;
		
		while(i<=j){
			if(data[i]>data[j]){
				
			}
		}
		return sum;
	}
}

