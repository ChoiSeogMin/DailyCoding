package random_question.problem_12100_2048_Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12100_2048_EASY{

	public static void main(String[] args) throws NumberFormatException, IOException{
		int[][] data = new InputDevice().getInitData();
		solution(data);
	}
	
	private static void solution(int[][] data){
	    
		int[][][] mData = new int[1365][data.length][data[0].length];
		mData[0] = data;
		for(int k=0; k<341; k++){
			for(int i=0; i<4; i++){
				mData[((k+1)*4)-i] = makeMatrix(mData[k],i);
			}				
		}
		
		for(int o=0; o<20; o++){
			printData(mData[o]);
		}
		
		int result = 0;
		for(int j=0; j<1365; j++){
			for(int i=0; i<data.length; i++){
				for(int m=0; m<data[i].length; m++){
					result = Math.max(mData[j][i][m], result);
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	private static int[][] makeMatrix(int[][] data2,int i){
		
		int[][] data = copyArrayList(data2);
		
		switch(i){
		case 0: //왼쪽
			for(int j=0; j<data.length; j++){
				int temp = 0;//0번쨰 까지 떙길 수 있다.
				for(int k=0; k<data.length; k++){
					for(int s=k; s>temp; s--){
						if(data[j][s]==0)
							break;
						if(data[j][s-1]==0){
							data[j][s-1] = data[j][s];
							data[j][s] = 0; 
						}else if(data[j][s-1]==data[j][s]){
							data[j][s-1] += data[j][s];
							data[j][s] = 0;
							temp = s;
						}else if(data[j][s-1]!=data[j][s]){
							temp=s;
						}
					}
				}
			}
			break;
		case 1: //오른쪽
			for(int j=0; j<data.length; j++){
				int temp = data.length-1;//마지막 index까지 떙길 수 있다.
				for(int k=data.length-1; k>=0; k--){
					for(int s=k; s<temp; s++){
						if(data[j][s]==0)
							break;
						if(data[j][s+1]==0){
							data[j][s+1] = data[j][s];
							data[j][s] = 0; 
						}else if(data[j][s+1]==data[j][s]){
							data[j][s+1] += data[j][s];
							data[j][s] = 0;
							temp = s;
						}else if(data[j][s+1]!=data[j][s]){
							temp= s;
						}
					}
				}
			}
			break;
		case 2: //위로
			for(int j=0; j<data.length; j++){
				int temp = 0;//0번쨰 까지 떙길 수 있다.
				for(int k=0; k<data.length; k++){
					for(int s=k; s>temp; s--){
						if(data[s][j]==0)
							break;
						if(data[s-1][j]==0){
							data[s-1][j] = data[s][j];
							data[s][j] = 0; 
						}else if(data[s-1][j]==data[s][j]){
							data[s-1][j] += data[s][j];
							data[s][j] = 0;
							temp = s;
						}else if(data[s-1][j]!=data[s][j]){
							temp=s;
						}
					}
				}
			}
			break;
		case 3: //아래로
			for(int j=0; j<data.length; j++){
				int temp = data.length-1;//마지막 index까지 떙길 수 있다.
				for(int k=data.length-1; k>=0; k--){
					for(int s=k; s<temp; s++){
						if(data[s][j]==0)
							break;
						if(data[s+1][j]==0){
							data[s+1][j] = data[s][j];
							data[s][j] = 0; 
						}else if(data[s+1][j]==data[s][j]){
							data[s+1][j] += data[s][j];
							data[s][j] = 0;
							temp = s;
						}else if(data[s+1][j]!=data[s][j]){
							temp= s;
						}
					}
				}
			}
			break;
		}
		return data;
	}
	
	private static int[][] copyArrayList(int[][] matrix){
		
		int data[][] = new int[matrix.length][matrix.length];
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				data[i][j] = matrix[i][j];
			}
		}
		
		return data;
	}
	
	private static void printData(int[][] data){
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length; j++){
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
}

class InputDevice{
	
	public int[][] getInitData() throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[][] data = new int[n][n];
		
		for(int i=0; i<n; i++){
			String[] str = br.readLine().split(" ");
			for(int j=0; j<str.length; j++){
				data[i][j] = Integer.valueOf(str[j]);
			}
		}
		
		return data;
	}
}
