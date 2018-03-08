package graph.floodFill.problem_2178_최단거리구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * �ִܰŸ��� ���� BFS�� Ǳ�ϴ�.
 * @author �ּ���
 *
 */
public class Main_2178 {
	
	private static final int[] dx = {0,0,1,-1};
	private static final int[] dy = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] initNum = new int[2];
		int k = 0;
		for(String data:br.readLine().split(" ")){
			initNum[k++] = Integer.valueOf(data);
		}
		
		int[][] map = new int[initNum[0]][initNum[1]];
		int[][] result = new int[initNum[0]][initNum[1]];
		k = 0;
		for(int i=0; i<map.length; i++){
			for(char data:br.readLine().toCharArray()){
				map[i][k++] = data - '0';
			}
			k = 0;
		}
		
		System.out.println(getMostShortRange(map,result));
	}
	
	private static int getMostShortRange(int[][] map,int[][] result){
	
		Queue<Pair> queue = new LinkedList<Pair>();
		//startPoint
		result[0][0] = 1;
		int value = 1;
		queue.add(new Pair(0,0,value));
		
		while(!queue.isEmpty()){
			Pair pair = queue.remove();
			
			for(int i=0; i<dx.length; i++){
				
				int nx = pair.x + dx[i];
				int ny = pair.y + dy[i];
				
				if(0<=nx && nx<map[0].length && 0<=ny && ny<map.length){
					if(result[ny][nx]==0 && map[ny][nx] ==1){//�������� ���� ��
						result[ny][nx] = pair.value+1; // ++���ϸ� pairValue ��ü�� ������Ų���̱� ����
						
						if(isLastNodeArrive(nx,ny,map)){
							return result[ny][nx];
						}
						
						queue.add(new Pair(nx,ny,result[ny][nx]));
					}
				}
			}
		}
		
		return -1;
	}
	
	private static boolean isLastNodeArrive(int nx,int ny,int[][] map){
		
		
		if(ny==(map.length-1)&&nx==(map[0].length-1)){
			return true;
		}
			
		return false;
	}
}

class Pair{
	public int x;
	public int y;
	public int value;
	
	public Pair(int x,int y,int value){
		this.x = x;
		this.y = y;
		this.value = value;
	}
}
