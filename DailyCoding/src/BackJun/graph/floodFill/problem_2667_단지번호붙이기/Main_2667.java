package graph.floodFill.problem_2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
	
	private static BufferedReader br;
	private static int[][] inputData;
	private static int[][] result;
	private static Queue<Pair> queue;
	private static int cnt = 1;
	
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		queue =  new LinkedList<Pair>();
		br = new BufferedReader(new InputStreamReader(System.in));
		int lineNum = Integer.valueOf(br.readLine());
		inputData = readInputData(lineNum);
		result = new int[lineNum][lineNum];
		int[] finalResult = getResultArea(inputData);
		Arrays.sort(finalResult);
		
		StringBuilder sb =new StringBuilder();
		sb.append((cnt-1)+"\n");
		for(int i=1; i<cnt; i++){
			sb.append(finalResult[i]+"\n");
		}
		
		System.out.println(sb);
	}
	
	private static int[][] readInputData(int num) throws IOException{
		
		int[][] intPutData = new int[num][num];
		
		for(int i=0; i<num; i++){
			char[] lineData = br.readLine().toCharArray();
			for(int j=0; j<num; j++){
				intPutData[i][j] = lineData[j]-'0';
			}
		}
		return intPutData;
	}
	
	private static int[] getResultArea(int[][] data){
		//data�� ���簢��
		/*LinkedList�� Queue�� �����Ѵ�.*/
		//startPoint
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				if(data[i][j]==1 && result[i][j]==0){
					searchCommonArea(new Pair(i,j),cnt++);
				}
			}
		}
		
		int[] index = new int[cnt];
		
		for(int i=0; i<result.length; i++){
			for(int j=0; j<result[i].length; j++){
				if(result[i][j]!=0){
					index[result[i][j]]++;
				}
			}
		}
		return index;
	}
	
	private static void searchCommonArea(Pair pair,int cnt){
		queue.add(pair);
		
		while(!queue.isEmpty()){
			Pair data = queue.remove();
			result[data.y][data.x] = cnt; //ã�� ����� �������� CNT������ MAPPING�Ѵ�. 
				for(int i=0; i<dx.length; i++){
					int nextX = data.x+dx[i]; 
					int nextY = data.y+dy[i];
					if(nextX>=0&&nextY>=0&&nextY<inputData.length&&nextX<inputData.length){ 
						if(inputData[nextY][nextX]==1&&result[nextY][nextX]==0){
							queue.add(new Pair(data.y+dy[i],data.x+dx[i]));
						}
					}
				}
		}
		
	}
}

class Pair{
	public int x;
	public int y;
	
	
	public Pair(int y,int x){
		this.y = y;
		this.x = x;
	}
}