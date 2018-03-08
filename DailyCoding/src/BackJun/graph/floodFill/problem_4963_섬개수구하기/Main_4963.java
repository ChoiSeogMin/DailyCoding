package graph.floodFill.problem_4963_섬개수구하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x;
	int y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main_4963{
	
	private static final int[] dx = {0, 0, 1,-1, 1, 1,-1,-1};
	private static final int[] dy = {1,-1, 0, 0,-1, 1,-1, 1};
	
	public static void main(String[] args){
		
		  Scanner sc = new Scanner(System.in);
		 
		  
	        while (true) {
	            int m = sc.nextInt();
	            int n = sc.nextInt();
	            if (n == 0 && m == 0) {
	                break;
	            }

	            int[][] a = new int[n][m];
	            for (int i=0; i<n; i++) {
	                for (int j=0; j<m; j++) {
	                    a[i][j] = sc.nextInt();
	                }
	            }
	            int cnt = 0;
	            int result[][] = new int[n][m];
	            
	    		for(int i=0; i<n; i++){
	    			for(int j=0; j<m; j++){
	    				if(result[i][j]==0 && a[i][j]==1){
	    					bfs(i,j,a,result,++cnt,m,n);
	    				}
	    			}
	    		}
	    		
	    		System.out.println(cnt);
	        }
	}
	
	private static void bfs(int y,int x,int[][] map,int[][] result,int cnt,int m,int n){
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(x,y));
		result[y][x] = cnt;
		int nx = 0;
		int ny = 0;
		while(!queue.isEmpty()){
			Pair pair = queue.remove();
			result[pair.y][pair.x] = cnt;
			for(int i=0; i<8; i++){
				nx = pair.x + dx[i];
				ny = pair.y + dy[i];
				
				if(0<=nx && nx<m && 0<=ny && ny<n){
					if(map[ny][nx]==1 && result[ny][nx]==0){
						//���⼭ �ٲ��� ������ ��û���� ����Ѵ�. 8�����̶� ��û���� �� ã�ƺ���.
						//ã���� �ٷιٷ� �����ؾ� �Ѵ�.
						//result[ny][nx] = cnt; ã�ڸ���, �����ؼ� �������� �Ȼ��ǰ� �ٲ�� �Ѵ�.
						result[ny][nx] = cnt;
						queue.add(new Pair(nx,ny));
					}
				}
			}
		}
		
	}
	
}
