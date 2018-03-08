package dynamicProgramming.problem_10942_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10942 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		int[] data = new int[initialNum];
		int[][] memory = new int[initialNum][initialNum];
		
		int i =0;
		for(String intStr:br.readLine().split(" ")){
			data[i++] = Integer.valueOf(intStr);
		}
		getPelMemoryDatya(data,memory);
		
		int nextQuestionNum = Integer.valueOf(br.readLine());
		int[][] question = new int[nextQuestionNum][2];
		
		for(int j=0; j<nextQuestionNum; j++){
			String[] questionStr = br.readLine().split(" ");
			question[j][0] = Integer.valueOf(questionStr[0]);
			question[j][1] = Integer.valueOf(questionStr[1]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<nextQuestionNum; j++){
			if(question[j][0]==question[j][1])
				sb.append(1+"\n");
			else
				sb.append(memory[question[j][0]-1][question[j][1]-1]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void getPelMemoryDatya(int[] data,int[][] memory){
		//���̰� 2�϶��� ���̰� 3�ϋ��� ���Ѵ�. 
		for(int l = 2; l<=data.length; l++){
			for(int index=0; index<=data.length-l; index++){
				if(l==2||l==3){
					if(data[index]==data[index+l-1]){
						memory[index][index+l-1] = 1;
					}
				}else{
					if(data[index]==data[index+l-1]){
						if(memory[index+1][index+l-2] == 1){
							memory[index][index+l-1] = 1;
						}else{
							memory[index][index+l-1] = 0;
						}
					}
				}
			}
		}
	}
}
