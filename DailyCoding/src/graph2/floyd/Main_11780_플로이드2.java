package graph2.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main_11780_플로이드2 {

	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int k = Integer.valueOf(br.readLine());
		
		int[][] data = new int[n][n];
		int[][] v = new int[n][n];
		for(int i=0; i<v.length; i++)
			Arrays.fill(v[i], -1);
		
		for(int i=0; i<k; i++){
			String[] str = br.readLine().split(" ");
			int s = Integer.valueOf(str[0]);
			int e = Integer.valueOf(str[1]);
			int cost = Integer.valueOf(str[2]);
			
			if(data[s-1][e-1]!=0){
				data[s-1][e-1] = Math.min(data[s-1][e-1], cost);
			}else{
				data[s-1][e-1] = cost;
			}
		}
		
		solution(v,data,n);
	}
	
	private static void solution(int[][] v,int[][] data,int n){
		
		for(int k=0; k<n; k++){
			for(int i=0; i<data.length; i++){
				for(int j=0; j<data[i].length; j++){
					if(i==j)
						continue;
					
					if(data[i][k] != 0 && data[k][j] != 0){
						
						if(data[i][j]==0){
							
							data[i][j] = data[i][k] + data[k][j];
							v[i][j] = k; //i ~ j갈때 k를 거쳐 간다.
						}else{
							if(data[i][j]>data[i][k] + data[k][j]){
								data[i][j] = Math.min(data[i][j], data[i][k] + data[k][j]);
								v[i][j] = k; //i ~ j갈때 k를 거쳐 간다.
								//1 5 // 1  2  5 // 1 2 = 0 
							}
						}
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				if(i==j){
					sb.append("0\n");
					continue;
				}else{
					cnt = 2;
					String d2 = ((i+1)+" "+getLineData(v,i,j)+(j+1)+"\n");
					sb.append(cnt+" "+d2);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static String getLineData(int[][] v,int i,int j){
		if(v[i][j]==-1){
			return "";
		}else{
			cnt++;
		}
		return getLineData(v,i,v[i][j])+(v[i][j]+1)+" "+getLineData(v,v[i][j],j);
	}
}
