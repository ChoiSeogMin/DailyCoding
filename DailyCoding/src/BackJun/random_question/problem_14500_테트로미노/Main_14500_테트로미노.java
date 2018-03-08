package random_question.problem_14500_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14500_테트로미노 {

	public static int result = 0;
	public static final int dx[] = {0,0,1,-1};
	public static final int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] d = br.readLine().split(" ");
		int y = Integer.valueOf(d[0]);
		int x = Integer.valueOf(d[1]);
		
		int[][] data = new int[y][x];
		
		for(int i=0; i<y; i++){
			String[] line = br.readLine().split(" ");
			int j = 0;
			for(String k:line){
				data[i][j++] = Integer.valueOf(k);
			}
		}
		
		solution(data);
	}
	
	private static void solution(int[][] data){
		
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				searchArea(i,j,i,j,data[i][j],1,data);
			}
		}
		
		System.out.println(result);
	}
	
	private static void searchArea(int y, int x, int prey, int prex, int sum,int count,int[][] data){
		int re = 0;
		boolean syntax = false;
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=ny && ny<data.length && 0 <=nx && nx < data[i].length && !(nx == prex && ny == prey))
			{
				
				if(syntax){
					result = Math.max(result,re+data[ny][nx]);
					syntax = false;
					re = 0;
				}
				
				if(count==2){
					re = sum+data[ny][nx];
					syntax = true;
				}
				
				if(count!=3){
					searchArea(ny,nx,y,x,sum+data[ny][nx],count+1,data);
				}else{
					result = Math.max(result,sum+data[ny][nx]);
				}
			}
		}
	}
}
