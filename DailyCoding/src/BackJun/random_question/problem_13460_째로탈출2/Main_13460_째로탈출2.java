package random_question.problem_13460_째로탈출2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_13460_째로탈출2 {

	
	private static final int LIMIT = 10;
	private static int result = 11;
	
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	
	public static void main(String[] args) throws IOException{
		
		InputDevice_13460 input = new InputDevice_13460();
		char[][] data = input.getInitData();
		Goosle r = input.getR();
		Goosle b = input.getB();
		
		solution(data,r,b,1);
		
		if(result == 11)
			System.out.println(-1);
		else
			System.out.println(result);
	}
	
	private static void solution(char[][] data, Goosle r, Goosle b,int count){
		if(count>LIMIT)
			return;
		char[][] nextData = null;
		
		for(int i=0; i<4; i++){
			Goosle nextR = new Goosle(r.y,r.x,r.ch);
			Goosle nextB = new Goosle(b.y,b.x,b.ch);
			nextData = switchZZroBox(i,nextR,nextB,copyData(data),count);
			if(nextData!=null)
				solution(nextData,nextR,nextB,count+1);	
		}
	}
	
	private static char[][] copyData(char[][] data){
		char[][] copyData = new char[data.length][data[0].length];
		
		for(int i=0; i<data.length; i++){
			copyData[i] = Arrays.copyOf(data[i],data[i].length);
		}
		
		return copyData;
	}
	
	private static char[][] switchZZroBox(int direction, Goosle r, Goosle b, char[][] data,int count){
		
		boolean isRgoalIn = false;
		boolean isBgoalIn = false;
		
		switch(direction){
		
		case LEFT:
			
			if(r.y == b.y){ //Y좌표 같으면 순서를 지켜야 한다.
				if(r.x < b.x){
					isRgoalIn = isLeftMoveGoalIn(data,r);
					isBgoalIn = isLeftMoveGoalIn(data,b);
				}else{
					isBgoalIn = isLeftMoveGoalIn(data,b);
					isRgoalIn = isLeftMoveGoalIn(data,r);
				}
			}else{//Y좌표 다르면 아무거나 옮겨라
				isRgoalIn = isLeftMoveGoalIn(data,r);
				isBgoalIn = isLeftMoveGoalIn(data,b);
			}
			
			break;
		case RIGHT:
			if(r.y == b.y){ //Y좌표 같으면 순서를 지켜야 한다.
				if(r.x > b.x){
					isRgoalIn = isRightMoveGoalIn(data,r);
					isBgoalIn = isRightMoveGoalIn(data,b);
				}else{
					isBgoalIn = isRightMoveGoalIn(data,b);
					isRgoalIn = isRightMoveGoalIn(data,r);
				}
			}else{//Y좌표 다르면 아무거나 옮겨라
				isRgoalIn = isRightMoveGoalIn(data,r);
				isBgoalIn = isRightMoveGoalIn(data,b);
			}
			break;
		case UP:
			if(r.x == b.x){ //Y좌표 같으면 순서를 지켜야 한다.
				if(r.y > b.y){
					isBgoalIn = isUpMoveGoalIn(data,b);
					isRgoalIn = isUpMoveGoalIn(data,r);
				}else{
					isRgoalIn = isUpMoveGoalIn(data,r);
					isBgoalIn = isUpMoveGoalIn(data,b);
				}
			}else{//Y좌표 다르면 아무거나 옮겨라
				isRgoalIn = isUpMoveGoalIn(data,r);
				isBgoalIn = isUpMoveGoalIn(data,b);
			}
			break;
		case DOWN:
			if(r.x == b.x){ //Y좌표 같으면 순서를 지켜야 한다.
				if(r.y > b.y){
					isRgoalIn = isDownMoveGoalIn(data,r);
					isBgoalIn = isDownMoveGoalIn(data,b);
				}else{
					isBgoalIn = isDownMoveGoalIn(data,b);
					isRgoalIn = isDownMoveGoalIn(data,r);
				}
			}else{//Y좌표 다르면 아무거나 옮겨라
				isRgoalIn = isDownMoveGoalIn(data,r);
				isBgoalIn = isDownMoveGoalIn(data,b);
			}
			break;
		}
		
		if(isRgoalIn == false && isBgoalIn == false){
			return data;
		}else if(isRgoalIn == true && isBgoalIn == false){//이 뒤부터는 더이상 셀 필요가 없다.
			result = Math.min(result, count);
		}else if(isRgoalIn == false && isBgoalIn == true){
			return null;
		}else if(isRgoalIn == true && isBgoalIn == true){
			return null;
		}
		return null;
	}
	
	private static boolean isLeftMoveGoalIn(char[][] data, Goosle r){
		
		while(true){
			int tempX = r.x - 1;//left는 하나씩줄인다.
			if(data[r.y][tempX]=='.'){
				data[r.y][r.x] = '.';
				data[r.y][tempX] = r.ch;
				r.x = tempX;
			}else if(data[r.y][tempX]=='#'){
				break;
			}else if(data[r.y][tempX]=='R'){
				break;
			}else if(data[r.y][tempX]=='B'){
				break;
			}else if(data[r.y][tempX]=='O'){
				data[r.y][r.x]='.';
				return true;
			}
		}
		return false;
	}
	
	private static boolean isRightMoveGoalIn(char[][] data, Goosle r){
		
		while(true){
			int tempX = r.x + 1;//left는 하나씩줄인다.
			if(data[r.y][tempX]=='.'){
				data[r.y][r.x] = '.';
				data[r.y][tempX] = r.ch;
				r.x = tempX;
			}else if(data[r.y][tempX]=='#'){
				break;
			}else if(data[r.y][tempX]=='R'){
				break;
			}else if(data[r.y][tempX]=='B'){
				break;
			}else if(data[r.y][tempX]=='O'){
				data[r.y][r.x]='.';
				return true;
			}
		}
		return false;
	}
	
	private static boolean isUpMoveGoalIn(char[][] data, Goosle r){
		
		while(true){
			int tempY = r.y - 1;//left는 하나씩줄인다.
			if(data[tempY][r.x]=='.'){
				data[r.y][r.x] = '.';
				data[tempY][r.x] = r.ch;
				r.y = tempY;
			}else if(data[tempY][r.x]=='#'){
				break;
			}else if(data[tempY][r.x]=='R'){
				break;
			}else if(data[tempY][r.x]=='B'){
				break;
			}else if(data[tempY][r.x]=='O'){
				data[r.y][r.x]='.';
				return true;
			}
		}
		return false;
	}

	private static boolean isDownMoveGoalIn(char[][] data, Goosle r){
	
		while(true){
			int tempY = r.y + 1;//left는 하나씩줄인다.
			if(data[tempY][r.x]=='.'){
				data[r.y][r.x] = '.';
				data[tempY][r.x] = r.ch;
				r.y = tempY;
			}else if(data[tempY][r.x]=='#'){
				break;
			}else if(data[tempY][r.x]=='R'){
				break;
			}else if(data[tempY][r.x]=='B'){
				break;
			}else if(data[tempY][r.x]=='O'){
				data[r.y][r.x]='.';
				return true;
			}
		}
		return false;
}
	
	private static void printdata(char[][] data){
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}
}
	

class InputDevice_13460{
	
	Goosle r;
	Goosle b;
	
	public char[][] getInitData() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int n = Integer.valueOf(data[0]);
		int m = Integer.valueOf(data[1]);
		
		char[][] initialData = new char[n][m];
		int k =0;
		for(int i=0; i<n; i++){	
			for(char d:br.readLine().toCharArray()){
				if(d == 'R'){
					r = new Goosle(i,k,'R');
				}else if(d == 'B'){
					b = new Goosle(i,k,'B');
				}
				initialData[i][k++] = d;
			}
			k = 0;
		}
		return initialData;
	}

	public Goosle getR() {
		return r;
	}

	public Goosle getB() {
		return b;
	}

}

class Goosle{
	int x;
	int y;
	char ch;
	public Goosle(int y,int x, char ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
}
