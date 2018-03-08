package random_question.problem_14501_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14501_퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		Class[] data = new Class[initialNum];
		
		for(int i=0; i<initialNum; i++){
			String[] line = br.readLine().split(" ");
			data[i] = new Class(Integer.valueOf(line[0]),Integer.valueOf(line[1]));
		}
		
		solution(data);
	}
	
	private static void solution(Class[] data){
		int totalCost[] = new int[data.length];
		int maxResult = 0;
		for(int i=0; i<data.length; i++){
			if(i>=1){
				int preValue = findPreMaxValue(totalCost,i);
				if(preValue!=0){
					int sum = preValue + data[i].cost;
					if(i+data[i].time-1<data.length){
						totalCost[i+data[i].time-1] = Math.max(totalCost[i+data[i].time-1], sum);
					}
				}else{
					int sum = data[i].cost;
					if(i+data[i].time-1<data.length){
						totalCost[i+data[i].time-1] = Math.max(totalCost[i+data[i].time-1], sum);
					}
				}
			}else{
				int sum = data[i].cost;
				if(i+data[i].time-1<data.length){
					totalCost[i+data[i].time-1] = Math.max(totalCost[i+data[i].time-1], sum);
				}
			}
			
			maxResult = Math.max(totalCost[i], maxResult);
		}
		
		System.out.println(maxResult);
	}
	
	private static int findPreMaxValue(int[] totalCost, int index){
		int resultMax = 0;
		
		for(int j=index-1; j>=0; j--){
			resultMax = Math.max(totalCost[j], resultMax);
		}
		return resultMax;
	}

}

class Class{
	
	int time;
	int cost;
	
	public Class(int time, int cost){
		this.time = time;
		this.cost = cost;
	}
}
