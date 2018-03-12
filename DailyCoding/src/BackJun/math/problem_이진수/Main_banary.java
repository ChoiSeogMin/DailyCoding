package problem_이진수;

public class Main_banary {

	 	public static void main(String[] args){
	    	System.out.println(solution(22));
	    }
	    
		private static int solution(int N) {
	        // write your code in Java SE 8
	        boolean start = false;
	        int maxGap = 0;
	        int count = 0;
	        while(true){
	            
	        	if(N==0)
		        	 break;
	        	
		         int data = N % 2; //05 12 01 
		         N = N/2;  
		         
		         if(data==1&&start==false){
		             //start
		             start = true;
		             continue;
		         }else if(data==1&&start==true){
		               maxGap = Math.max(maxGap,count);
		               count=0;
		               continue;
		         }
		         if(start){
		             count++;
		        }
	        }
	        return maxGap;
	    }
}
