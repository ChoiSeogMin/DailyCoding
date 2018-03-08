package dynamicProgramming.problem_11726_2n타일링;

import java.util.Scanner;

public class Main_11726 {

//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		long[] m = new long[n+1];
//		System.out.println(getTailCount(m,n));
//	}
//	
//	private static long getTailCount(long[] data,int n){
//		
//		if(n<=1)
//			return 1;
//		
//		if(data[n]>0)
//			return data[n];
//		
//		data[n] = (getTailCount(data,n-1) + getTailCount(data,n-2)) % 10007;
//		
//		return data[n];
//	}
	
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int[] d = new int[1001];
	        d[0] = 1;
	        d[1] = 1;
	        for (int i=2; i<=n; i++) {
	            d[i] = d[i-1] + d[i-2];
	            d[i] %= 10007;
	        }
	        System.out.println(d[n]);
	    }
}
