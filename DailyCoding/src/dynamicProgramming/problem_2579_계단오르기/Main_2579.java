package dynamicProgramming.problem_2579_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
//6 1 1 0 0 1 1 과 같은 예외 케이스들을 확인해 봐야 한다. 이렇게 하면 마지막껀 무조건 밝음.
//validation처리는 가장 작은 값을 생각하자.
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		int[] data = new int[initialNum+1];
		int[][] m = new int[initialNum+1][2];
		for(int i=1; i<=initialNum; i++){
			data[i] = Integer.valueOf(br.readLine());
		}
		
		System.out.println(getResultNum(data,m,initialNum));
		
	}
	private static int getResultNum(int[] data,int[][] m, int initialNum){
		m[1][0] = data[1];
		if(initialNum >= 2){
			m[2][0] = data[2];
			m[2][1] = data[1] + data[2];	
		}
		for(int i=3; i<=initialNum; i++){
			m[i][0] = m[i-2][1]+data[i]; //점프해서 첫번째
			m[i][0] = Math.max(m[i][0],m[i-2][0]+data[i]);
			m[i][1] = m[i-1][0]+data[i]; //점프하지 않고 연달라 두번째
		}
		return Math.max(m[initialNum][0], m[initialNum][1]);
	}
}
