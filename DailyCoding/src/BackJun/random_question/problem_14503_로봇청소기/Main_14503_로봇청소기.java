
package random_question.problem_14503_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14503{

	private static int[] dx = new int[4];
	private static int[] dy = new int[4];
	private static Queue<Pair2> queue = new LinkedList<Pair2>();

	private static final Pair2 BOOK = new Pair2(-1,0,0);
	private static final Pair2 DONG = new Pair2(0,1,1);
	private static final Pair2 NAM = new Pair2(1,0,2);
	private static final Pair2 SU = new Pair2(0,-1,3);

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] initial = br.readLine().split(" ");
		int y = Integer.valueOf(initial[0]);
		int x = Integer.valueOf(initial[1]);

		int[][] data = new int[y][x];
		boolean[][] isClear = new boolean[y][x];

		String[] startIndex = br.readLine().split(" ");
		int startY = Integer.valueOf(startIndex[0]);
		int startX = Integer.valueOf(startIndex[1]);
		int direction = Integer.valueOf(startIndex[2]);
		queue.add(new Pair2(startY,startX,direction));

		for(int i=0; i<y; i++){
			int j=0;
			for(String s:br.readLine().split(" ")){
				int d = Integer.valueOf(s);
				data[i][j] = d;
				if(d==1){
					isClear[i][j] = true;
				}
				j++;
			}
		}

		solution(data,isClear);
	}

	private static void solution(int[][] data,boolean[][] isClear) {

		int result = 0;
		int k = 0;

		while (queue.size() != 0) {
			Pair2 nd = queue.poll();
			int nowDirection = nd.direction;
			boolean isClearField = false;

			if (isClear[nd.y][nd.x] == false) {
				isClear[nd.y][nd.x] = true;
				result++;
			}

			for (int i = 0; i < 4; i++) {

				Pair2 next = getNext(nowDirection);
				int ny = nd.y + next.y;
				int nx = nd.x + next.x;

				if (0 <= ny && ny < data.length && 0 <= nx && nx < data[0].length) {
					if (data[ny][nx] != 1 && isClear[ny][nx] == false) {
						queue.add(new Pair2(ny, nx, next.direction));
						isClearField = true;
						break;
					}
				}

				nowDirection = next.direction;
			}

			if(!isClearField){
				Pair2 bn = getBackNext(nd.direction);
				int ny = bn.y + nd.y;
				int nx = bn.x + nd.x;

				if(0<= ny && ny < data.length && 0<= nx && nx < data[0].length){
					if(!(data[ny][nx]==1)){
						queue.add(new Pair2(ny,nx,nd.direction));
					}
				}

			}
		}

		System.out.println(result);
	}


	private static Pair2 getNext(int nowDirection){

		switch(nowDirection){
			case 0:
				return SU;
			case 1:
				return BOOK;
			case 2:
				return DONG;
			case 3:
				return NAM;
		}

		return null;
	}

	private static Pair2 getBackNext(int nowDirection){

		switch(nowDirection){
			case 0:
				return NAM;
			case 1:
				return SU;
			case 2:
				return BOOK;
			case 3:
				return DONG;
		}

		return null;

	}
}

class Pair2{
	int y;
	int x;
	int direction;

	public Pair2(int y, int x, int direction){
		this.y = y;
		this.x = x;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Y:"+y+","+"X:"+x+"direction:"+direction;
	}
}
