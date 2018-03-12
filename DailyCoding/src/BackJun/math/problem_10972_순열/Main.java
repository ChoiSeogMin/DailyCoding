package problem_10972_순열;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		int[] data = {1,2,3,4,5};
		
		nextPulmutation(data);
		printArrayData(data);

	}
	
	public static void nextPulmutation(int[] data){
		
		int i = data.length - 1;
		int j = data.length - 1;
		
		while(i>0&&data[i-1]>data[i]){
			i--;
		}
		
		if(i==0){
			System.out.println(-1);
			return;
		}
		
		while(data[j-1]>data[j]&&data[i-1]>data[j]){
			j--;
		}
		
		int temp = data[i-1];
		data[i-1] = data[j];
		data[j] = temp;
		j = data.length - 1;
		
		while(i<j){
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void printArrayData(int[] n){
		StringBuffer sb = new StringBuffer();
		for(int k:n){
			sb.append(k+" ");
		}
		System.out.println(sb.toString());
	}
}
