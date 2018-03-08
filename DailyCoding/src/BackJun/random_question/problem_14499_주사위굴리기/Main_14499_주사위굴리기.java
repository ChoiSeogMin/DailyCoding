package random_question.problem_14499_주사위굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14499_주사위굴리기 {

	public static void main(String[] args) throws IOException{
		int[] initialJusawi = {0,0,0,0,0,0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int n = Integer.valueOf(data[0]);
		int m = Integer.valueOf(data[1]);
		
		int x = Integer.valueOf(data[2]);
		int y = Integer.valueOf(data[3]);
		
		int k = Integer.valueOf(data[4]);
		int[] commandLine = new int[k];
		
		int[][] mapData = new int[n][m];
		int i=0;
		
		for(int j=0; j<n; j++){
			i=0;
			for(String d : br.readLine().split(" ")){
				mapData[j][i++] = Integer.valueOf(d);
			}
		}
		i=0;
		for(String command:br.readLine().split(" ")){
			commandLine[i++]= Integer.valueOf(command);
		}
		
		rollingJusawi(mapData,commandLine,initialJusawi,x,y);
	}
	

	

	private static void rollingJusawi(int[][] mapData,int[] commandLine,int[] data,int x,int y){
		StringBuilder sb = new StringBuilder();
		
		for(int cmd : commandLine){
			switch(cmd){
				case 1:
					if(y+1 < mapData[0].length){
						y++;
						swap(0,2,data);
						swap(0,5,data);
						swap(0,1,data);
						stumpData(x,y,data,mapData);
						sb.append(data[5]).append("\n");
					}
					break;
				case 2:
					if(y-1 >= 0){
						y--;
						swap(0,1,data);
						swap(0,5,data);
						swap(0,2,data);
						stumpData(x,y,data,mapData);
						sb.append(data[5]).append("\n");
					}
					break;
				case 3:
					if(x-1 >= 0){
						x--;
						swap(0,4,data);
						swap(0,5,data);
						swap(0,3,data);
						stumpData(x,y,data,mapData);
						sb.append(data[5]).append("\n");
					}
					break;
				case 4:
					if(x+1 < mapData.length){
						x++;
						swap(0,3,data);
						swap(0,5,data);
						swap(0,4,data);
						stumpData(x,y,data,mapData);
						sb.append(data[5]).append("\n");
					}
					break;
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static void stumpData(int x,int y,int[] jusawi,int[][] mapData){
		
		int k = mapData[x][y];
		if(k==0){
			mapData[x][y] = jusawi[0];
		}else{
			jusawi[0] = k;
			mapData[x][y] = 0;
		}
	}
	
	private static void swap(int n, int m, int[] initialJusawi){
		int temp = 0;
		temp = initialJusawi[n];
		initialJusawi[n] = initialJusawi[m];
		initialJusawi[m] = temp;
	}
}
