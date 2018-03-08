package graph.floodFill.problem_2146_섬다리잇기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1.input�� �ޱ�
 * 2. ���� �����ϱ�
 * 3. result�� �ʱ�ȭ
 * 4. ������ ������ bfs���� -> ���������� �� �Ÿ� ������ ���
 * 5. �����п��� ������ ���� �ٸ� �κ� ã��.
 * 6. �ٸ� �κ�ã�� �� �� �ּ� �� ���ϱ�.
 * 7. �ּҰ� ���
 * @author �ּ���
 *
 */
public class Main_2146 {
	
	private static final int[] dx = {0,0,1,-1};
	private static final int[] dy = {1,-1,0,0};
	private static Queue<Pair> queue = new LinkedList<Pair>();
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initNum = Integer.valueOf(br.readLine());
		int[][] map = new int[initNum][initNum];
		int[][] gubunIland = new int[initNum][initNum];
		int[][] gubunRange = new int[initNum][initNum];
		int k = 0;
		for(int i=0; i<map.length; i++){
			for(char data:br.readLine().replace(" ","").toCharArray()){
				map[i][k++] = data - '0';
			}
			k = 0;
		}
		int cnt = 0;
		
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				if(map[i][j]==1 && gubunIland[i][j]==0){
					searchCommonArea(new Pair(i,j),map,gubunIland,++cnt);
				}
			}
		}
		
		searchBridgeArea(map,gubunIland,gubunRange);
		findDiffrendState(gubunIland,gubunRange);
	//���е� ���� ã�Ƽ� bfs�� ������.		
	}
	
	private static void findDiffrendState(int[][] gubunIland,int[][] gubunRange){
		
		int minValue = 100000000;
		
		for(int i=0; i<gubunIland.length; i++){
			for(int j=0; j<gubunIland[i].length; j++){
				for(int k=0; k<dx.length; k++){
					int nextX = j+dx[k]; 
					int nextY = i+dy[k];
					
					if(0<=nextX&&nextX<gubunIland[0].length&&0<=nextY&&nextY<gubunIland.length ){ 
						if(gubunIland[nextY][nextX]!=gubunIland[i][j]){
							minValue = Math.min(minValue,(gubunRange[i][j]+gubunRange[nextY][nextX]));
						}
					}
					
				}
			}
		}
		
		System.out.println(minValue);
	}
	
	private static void searchBridgeArea(int[][] map,int[][] gubunIland,int[][] gubunRange){
		
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				if(gubunIland[i][j]!=0 && gubunRange[i][j]==0){ //�������̶�� ��,
					queue.add(new Pair(i,j,1));
				}
			}
		}
		
		while(!queue.isEmpty()){
			Pair data = queue.remove();
				for(int i=0; i<dx.length; i++){
					int nextX = data.x+dx[i]; 
					int nextY = data.y+dy[i];
					if(nextX>=0&&nextY>=0&&nextY<map.length&&nextX<map.length){ 
						if(map[nextY][nextX]==0&&gubunIland[nextY][nextX]==0){
							gubunIland[nextY][nextX] = gubunIland[data.y][data.x];
							gubunRange[nextY][nextX] = data.value;
							queue.add(new Pair(nextY,nextX,data.value + 1));
						}
					}
				}
		}
	}
	
	private static void searchCommonArea(Pair pair,int[][] map,int[][] gubunIland,int cnt){
		queue.add(pair);
		gubunIland[pair.y][pair.x] = cnt;
		
		while(!queue.isEmpty()){
			Pair data = queue.remove();
				for(int i=0; i<dx.length; i++){
					int nextX = data.x+dx[i]; 
					int nextY = data.y+dy[i];
					if(nextX>=0&&nextY>=0&&nextY<map.length&&nextX<map.length){ 
						if(map[nextY][nextX]==1&&gubunIland[nextY][nextX]==0){
							gubunIland[nextY][nextX] = cnt;
							queue.add(new Pair(data.y+dy[i],data.x+dx[i]));
						}
					}
				}
		}
	}
	
//	private static void printMapData(int[][] map){
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<map.length; i++){
//			for(int j=0; j<map[i].length; j++){
//				sb.append(map[i][j]);
//			}
//			sb.append("\n");
//		}
//		
//		System.out.println(sb.toString());
//	}
}


class Pair{
	public int x;
	public int y;
	public int value;
	
	public Pair(int y,int x){
		this.y = y;
		this.x = x;
		this.value = -1;
	}
	
	public Pair(int y,int x,int value){
		this.y = y;
		this.x = x;
		this.value = value;
	}
}
