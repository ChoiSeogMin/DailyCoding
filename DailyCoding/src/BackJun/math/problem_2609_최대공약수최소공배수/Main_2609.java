package problem_2609_최대공약수최소공배수;

import java.util.Scanner;

public class Main_2609 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		sc.nextLine();
		int gcd = gcd(num,num2);
		System.out.println(gcd);
		System.out.println(lcn(gcd,num,num2));
	}
	
	private static int gcd(int n1,int n2){
		int temp = 0;
		
		while(n1%n2!=0){
			temp = n1%n2;
			n1 = n2;
			n2 = temp;
		}		
		
		return n2;
	}
	
	private static int lcn(int gcd,int n1,int n2){
		
		int lcn = ((n1 / gcd) * (n2 / gcd)) * gcd;
		
		return lcn;
	}
	
}
