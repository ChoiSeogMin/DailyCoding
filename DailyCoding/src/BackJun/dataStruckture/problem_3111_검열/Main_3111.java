package dataStruckture.problem_3111_검열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Wrong Answer
 * @author 최석민
 *
 */
public class Main_3111 {

	//지웠을때  index를 당기면 error다.
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//char[] searchStr = br.readLine().toCharArray();
		//char[] dataStr = br.readLine().toCharArray();
		
		getResultDataSet("abc".toCharArray(),"fabaabcbcabccd".toCharArray());
		//getResultDataSet(searchStr,dataStr);		
	}
	//stack 사용시 3000만개 까진 생성 시간이 1초 이내로 끝난다.
	private static void getResultDataSet(char[] searchStr, char[] dataStr){
		
		Stack<Character> larr = new Stack<Character>();
		Stack<Character> rarr = new Stack<Character>();
		int searchLIndex = 0;
		int searchRIndex = dataStr.length - 1;
		boolean lstart = false;
		boolean rstart = false;
		
		int dataLength = searchStr.length;
		
		while(searchRIndex >= searchLIndex){
			
			int z = 0;
			while(larr.size() != 0){
				dataStr[--searchLIndex]=larr.pop();
				z++;
				if(z==dataLength-1)
					break;
			}
			
			while(searchRIndex >= searchLIndex){
				lstart = true;
				rstart = false;
				
				//똑같은걸 찾았다 시작.
				if(searchStr[0] == dataStr[searchLIndex]){
					int m = searchLIndex;
					int i = 0;
					for(i=0; i<dataLength && m<dataStr.length; i++){
						if(searchStr[i] == dataStr[m]){
							m++;
							continue;
						}
						break;
					}
					if(i==dataLength){//다 찾았다.
						searchLIndex += dataLength;
						break;
					}else{
						larr.push(dataStr[searchLIndex++]);
					}
				}else{
					larr.push(dataStr[searchLIndex++]);
				}
			}
		    
			z = 0;
			while(rarr.size() != 0){
				dataStr[++searchRIndex]=rarr.pop();
				z++;
				if(z==dataLength-1)
					break;
			}
			
			while(searchRIndex >= searchLIndex){
				rstart = true;
				lstart = false;
				
				//똑같은걸 찾았다 시작.
				if(searchStr[dataLength-1] == dataStr[searchRIndex]){
					int m = searchRIndex;
					int i = dataLength-1;
					for(i = dataLength-1; i>=0 && m>=0; i--){
						if(searchStr[i] == dataStr[m]){
							m--;
							continue;
						}
						break;
					}
					if(i==-1){//다 찾았다.
						searchRIndex -= dataLength;
						break;
					}else{
						rarr.push(dataStr[searchRIndex--]);
					}
				}else{
					rarr.push(dataStr[searchRIndex--]);
				}
			}
		}
		
		//method로 뺴서 다시 하자.
		
		System.out.println(larr);
		System.out.println(rarr);
		
		//System.out.println(String.valueOf(last).replaceAll(String.valueOf(searchStr), ""));
	}
}
