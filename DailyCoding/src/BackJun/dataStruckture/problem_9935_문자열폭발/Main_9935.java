package dataStruckture.problem_9935_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_9935 {

	private static Deque<Character> deque = new LinkedList<Character>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] data = br.readLine().toCharArray();
		char[] search = br.readLine().toCharArray();
		getSolution(data,search);
	}
	
	private static void getSolution(char[] data,char[] search){
		int n = search.length;
		int k = 0;
		for(int i=0; i<data.length; i++){
			if(search[0]==data[i]){
				k=1;
				for(int j=1; j<n; j++){
					if(j+i<data.length&&search[j]==data[i+j]){
						k++;
					}else{
						break;
					}
				}
				
				if(n==k){//count가 끝까지 돌았다.
					i+=(n-1);
					for(int j=0; j<n-1; j++){
						if(deque.size()!=0){
							data[i] = deque.removeLast();
							i--;
						}else
							break;
					}
				}else{
					deque.add(data[i]);
				}
			}else{
				deque.add(data[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(deque.size()==0)
			System.out.println("FRULA");
		else
			while(deque.size()!=0)
				sb.append(deque.removeFirst());
		System.out.println(sb.toString());
	}
}