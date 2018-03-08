package graph2.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1507_궁금한민호 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int data[][] = new int[n][n];
		
		boolean[][] loadData = new boolean[n][n];
		for(int i=0; i<loadData.length; i++){
			Arrays.fill(loadData[i], true);
			
		}
		
		for(int i=0; i<n; i++){
			int j = 0;
			for(String d:br.readLine().split(" ")){
				int loadCost = Integer.valueOf(d);
				data[i][j++] = loadCost;
			}
		}
		
		solution(data,loadData);
	}
	
	private static void solution(int[][] data, boolean[][] loadData){
		
		
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				if(i==j){
					loadData[i][j] = false;
					continue;
				}
				for(int k=0; k<data.length; k++){
					if(i==k)
						continue;
					if(j==k)
						continue;
					
					if(data[i][k]!=0&&data[k][j]!=0){
						if(data[i][j]== data[i][k] + data[k][j]){
							loadData[i][j] = false;
							loadData[i][j] = false;
						}else if(data[i][j]>data[i][k] + data[k][j]){
							System.out.println("-1");
							System.exit(0);
						}
					}
				}
			}
		}
		
		
		int result = 0;
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				if(loadData[i][j] == true){
					result += data[i][j];
					loadData[j][i] = false;
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	private static void printdata(int[][] data){
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void printdata(boolean[][] data){
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
}

