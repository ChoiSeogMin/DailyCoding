package graph2.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11404_플로이드 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int k = Integer.valueOf(br.readLine());
		
		int[][] data = new int[n][n]; 		
		
		for(int i=0; i<k; i++){
			String[] str = br.readLine().split(" ");
			int s = Integer.valueOf(str[0]);
			int e = Integer.valueOf(str[1]);
			int cost = Integer.valueOf(str[2]);
			
			if(data[s-1][e-1]==0){
				data[s-1][e-1] = cost;
			}else{
				if(data[s-1][e-1]!=0 && cost < data[s-1][e-1])
					data[s-1][e-1] = cost;
			}
			
		}
		
		solution(data);
	}
	
	private static void solution(int[][] data){
		StringBuilder sb = new StringBuilder();
		
		for(int k=0; k<data.length; k++){
			for(int i=0; i<data.length; i++){
				for(int j=0; j<data.length; j++){
					if(i==j)
						continue;
					
					if(data[i][k]!=0 && data[k][j]!=0){
						if(data[i][j]==0){
							data[i][j]= data[i][k] + data[k][j];
						}else{
							if(data[i][j]>data[i][k]+data[k][j]){
								data[i][j]=data[i][k]+data[k][j];
							}
						}
						
					}
				}
			}
		}
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				sb.append(data[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
