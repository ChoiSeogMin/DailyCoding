package dynamicProgramming.problem_피보나치;

public class Main_fibonaci {

	public static void main(String[] args){
		
		int n = 100;
		int data[] = new int[100];
		System.out.println(fibonaci(6,data));
	}
	//1 1 2 3 5 8 13
	private static int fibonaci(int n,int[] data){
		
		if(n<=1)
			return 1;
		if(data[n]>0)
			return data[n];
		data[n] = fibonaci(n-1,data) + fibonaci(n-2,data);
		
		return data[n];
	}
}
