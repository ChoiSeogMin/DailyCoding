package graph2.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1956_운동 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.valueOf(str[0]);
		int x = Integer.valueOf(str[1]);
		
		int[][] data = new int[n][n];
		
		for(int i=0; i<x; i++){
			String[] s = br.readLine().split(" ");
			data[Integer.valueOf(s[0])-1][Integer.valueOf(s[1])-1] = Integer.valueOf(s[2]);
		}
		
		solution(data);
	}
	
	private static void solution(int[][] data){
		
		for(int k=0; k<data.length; k++){
			for(int i=0; i<data.length; i++){
				if(k==i)
					continue;
				for(int j=0; j<data.length; j++){
					if(k==j)
						continue;
					if(i==j)
						continue;
					
					if(data[i][k]!=0 && data[k][j]!=0){
						if(data[i][j]==0){
							data[i][j] = data[i][k] + data[k][j]; 
						}else{
							if(data[i][j] > data[i][k] + data[k][j]){
								data[i][j] = data[i][k] + data[k][j];
							}
						}
					}
				}
			}
		}
		
		int result = 100000000;
		
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				if(i==j) continue;
				if(data[i][j]!=0 && data[j][i]!=0){
					int cycleCost = data[i][j] + data[j][i];
					result = Math.min(cycleCost, result);
				}
			}
		}
		
		if(result==100000000)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}
