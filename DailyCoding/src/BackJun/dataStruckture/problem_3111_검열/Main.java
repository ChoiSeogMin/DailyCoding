package dataStruckture.problem_3111_검열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * StringBuilder을 사용해 다시 풀어본 케이스
 * @author 최석민
 *
 */
public class Main {

   public static void main(String[] args) throws NumberFormatException, IOException{   
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String checkSb = "ba";
      StringBuilder sb = new StringBuilder();
      
      for(int i=0; i<500000; i++){
    	  sb.append("ab");
    	  //System.out.println(i);
      }
      solution(checkSb,sb);
   }
   
   private static void solution(String searchStr, StringBuilder originStr){
	   int i = 0; 
	      while(true){
	         int b = 0;
	   
	         if(i%2 == 0){
	            if((b = originStr.indexOf(searchStr)) > -1)
	            	originStr.delete(b, b+searchStr.length());
	            else
	               break;
	         }
	         else{
	            if((b = originStr.lastIndexOf(searchStr)) > -1)
	            	originStr.delete(b, b+searchStr.length());
	            else
	               break;
	         }
	         i++;
	      }
	      
	  System.out.println("Final");
	  System.out.println(originStr.toString());
   }
}
