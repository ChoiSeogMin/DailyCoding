package random_question.problem_14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14502_연구소 {

	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] intial = br.readLine().split(" ");
		int y = Integer.valueOf(intial[0]);
		int x = Integer.valueOf(intial[1]);
		
		int[][] data = new int[y][x];
		ArrayList<Pair> queue = new ArrayList<Pair>();
		ArrayList<Pair> array = new ArrayList<Pair>();
		
		
		for(int i=0; i<y; i++){
			int j=0;
			for(String str:br.readLine().split(" ")){
				data[i][j] = Integer.valueOf(str);
				if(data[i][j]==0){
					array.add(new Pair(i,j));
				}else if(data[i][j]==2){
					queue.add(new Pair(i,j));
				}
				j++;
			}
		}
		
		solution(data,array,queue);
	}
	
	public static void solution(int[][] data,ArrayList<Pair> array,ArrayList<Pair> queue){
		int result = 0;
		int copyData[][] = new int[data.length][data[0].length];
	
		for(int i=0; i<array.size(); i++){
			for(int j=0; j<array.size(); j++){
				if(j==i)
					continue;
				for(int k=0; k<array.size(); k++){
					if(k==j)
						continue;
					if(k==i)
						continue;
					
					for(int m=0; m<data.length; m++){
						copyData[m] = Arrays.copyOf(data[m], data[m].length);
					}
					
					Queue<Pair> q2 = new LinkedList<Pair>();
					for(int w=0; w<queue.size(); w++){
						q2.add(queue.get(w));
					}
					
					Pair one = array.get(i);
					Pair two = array.get(j);
					Pair three = array.get(k);
					
					copyData[one.y][one.x] = 1;
					copyData[two.y][two.x] = 1;
					copyData[three.y][three.x] = 1;
					
					result = Math.max(result, bfs(q2,copyData));
					
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static int bfs(Queue<Pair> queue, int[][] data){
		int result = 0;
		while(queue.size()!=0){
			Pair p = queue.poll();
			for(int i=0; i<4; i++){
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(0<=ny && ny<data.length && 0<=nx && nx <data[0].length){
					if(data[ny][nx]==0){
						data[ny][nx] = 2;
						queue.add(new Pair(ny,nx));
					}
				}
			}
		}
		
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				if(data[i][j]==0)
					result++;
			}
		}
		
		return result;
	}
	
}

class Pair{
	int y;
	int x;
	
	public Pair(int y,int x){
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "Pair [y=" + y + ", x=" + x + "]";
	}
	
	
}
