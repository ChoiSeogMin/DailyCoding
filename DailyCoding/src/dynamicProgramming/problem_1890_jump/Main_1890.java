package dynamicProgramming.problem_1890_jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1890 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		int[][] data = new int[initialNum][initialNum];
		long[][] memory = new long[initialNum][initialNum];
		
		for(int i=0; i<initialNum; i++){
			int j = 0;
			for(char s:br.readLine().replace(" ", "").toCharArray()){
				data[i][j++] = s - '0';
			}
		}
		
		findPossibleJumpRoute(data,memory);
		
		System.out.println(memory[initialNum-1][initialNum-1]);
	}
	/**
	 * ���ʰ� �������� �ش� �ʵ忡 ���� �����ϴ�. 
	 * @param data
	 * @param memory
	 */
	private static void findPossibleJumpRoute(int[][] data, long[][]memory){
		
		//ù������ 1�� ����
		memory[0][0] = 1;
		
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				int nextX = 0;
				int nextY = 0;
				while(true){
					nextX++;
					if(j-nextX>=0){
						if(data[i][j-nextX] == nextX){
							memory[i][j] += memory[i][j-nextX];
						}
					}else{
						break;
					}
				}
				
				while(true){
					nextY++;
					if(i-nextY>=0){
						if(data[i-nextY][j] == nextY){
							memory[i][j] += memory[i-nextY][j];
						}
					}else{
						break;
					}
				}
			}
		}
	}
}
