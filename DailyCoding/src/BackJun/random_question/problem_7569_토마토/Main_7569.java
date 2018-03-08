package random_question.problem_7569_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7569 {

	private static int dx[] = {1,-1,0,0};
	private static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strData = br.readLine().split(" ");
		
		int m = Integer.valueOf(strData[0]); //2 ~ 100
		int n = Integer.valueOf(strData[1]); //2 ~ 100
		int h = Integer.valueOf(strData[2]); //1 ~ 100
		
		int[][][] data = new int[m][n][h];
		
		for(int z=0; z<h; z++){
			for(int j=0; j<n; j++){
				int i = 0;
				for(String d:br.readLine().split(" ")){
					data[i++][j][z] = Integer.valueOf(d);
				}
			}
		}
		
		solution(data);
	}
	
	private static void solution(int[][][] data){
		Queue<Data> queue = new LinkedList<Data>();
		
		//initial

		for(int z=0; z<data[0][0].length; z++){
			for(int j=0; j<data[0].length; j++){
				for(int i=0; i<data.length; i++){
					if(data[i][j][z] == 1){
						queue.add(new Data(i,j,z,1));
					}
				}
			}
		}
		
		while(!queue.isEmpty()){
			Data d = queue.poll();

			for(int i=0; i<dx.length; i++){
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				
				if(0<=nextX && nextX<data.length && 0<=nextY && nextY<data[0].length){
					if(data[nextX][nextY][d.z]==0){
						data[nextX][nextY][d.z] = d.order+1;
						queue.add(new Data(nextX,nextY,d.z,d.order+1));
					}
				}
			}
			
			for(int i=0; i<2; i++){
				int nextZ = d.z + 1;
				if(i==1)
					nextZ = d.z - 1;
				if(nextZ>=0 && nextZ<data[0][0].length){
					if(data[d.x][d.y][nextZ]==0){
						data[d.x][d.y][nextZ] = d.order+1;
						queue.add(new Data(d.x,d.y,nextZ,d.order+1));
					}
				}
			}
		}
		
		System.out.println(getResult(data));
	}
	
	private static int getResult(int[][][] data){
		int maxValue = 0;
		for(int z=0; z<data[0][0].length; z++){
			for(int j=0; j<data[0].length; j++){
				for(int i=0; i<data.length; i++){
					if(data[i][j][z]==0)
						return -1;
					
					maxValue = Math.max(maxValue, data[i][j][z]);
				}
			}
		}
		
		return maxValue - 1;
	}
}

class Data{
	int x;
	int y;
	int z;
	int order;
	public Data(int x, int y, int z,int order){
		this.x = x;
		this.y = y;
		this.z = z;
		this.order = order;
	}
}