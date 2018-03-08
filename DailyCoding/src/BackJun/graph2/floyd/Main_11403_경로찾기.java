package graph2.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11403_경로찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[][] data = new int[n][n];
		
		for(int i=0; i<n; i++){
			String[] row = br.readLine().split(" ");
			for(int j=0; j<row.length; j++){
				int k = Integer.valueOf(row[j]);
				data[i][j] = k;
			}
		}
		
		solution(data);
	}
	
	private static void solution(int[][] data){
		int[][] result = new int[data.length][data.length];
		
	
		//floyd의 기본원리다. k는 중간 node이고, i~k k~j라면 i~j로 이어진다.
		for(int k=0; k<data.length; k++){
			for(int i=0; i<data.length; i++){
				for(int j=0; j<data.length; j++){
					if(data[i][k]==1 && data[k][j]==1){
						data[i][j] = 1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				sb.append(data[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
