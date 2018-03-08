package dynamicProgramming.problem_1463_1로만들기;

import java.util.Scanner;

public class problem_1463_1로만들기 {
	//3으로 나누거나,
	//2로 나누거나
	//1을 빼서 1을 만드는 최소 연산 횟수
	//d[n]은 n번쨰일때의 최소 연산 횟수다.
	
	
	private static int[] memoryData;
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memoryData = new int[n+1];
		System.out.println(dynamicPlan(n));
	}
	
	private static int dynamicPlan(int n){
		if(n==1)
			return 0;
		if(memoryData[n]>0)
			return memoryData[n];
		//빼기 연산
		memoryData[n] = dynamicPlan(n-1) + 1;
		int temp = 0;
		if(n % 2 ==0){
			temp = dynamicPlan(n/2) + 1;
			if(memoryData[n]>temp)
				memoryData[n] = temp;
		}
		if(n % 3 ==0){
			temp = dynamicPlan(n/3) + 1;
			if(memoryData[n]>temp)
				memoryData[n] = temp;
		}
		
		return memoryData[n];
	}
	
	
}
