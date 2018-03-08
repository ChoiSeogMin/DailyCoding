package graph2.dag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/***
 * Input 기준 A > B
 *          
 * @author 최석민
 *
 */
public class Main_Study_Alpabet {

	private static PriorityQueue<Character> prior = new PriorityQueue<>();
	private static HashMap<Character,ArrayList<Character>> dag;
	private static int[] alpaBat = new int[26]; 
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=65; i<91; i++){
			prior.add((char)(i));
		}
		
		Arrays.fill(alpaBat, -1);
		
		int initialNum = Integer.valueOf(br.readLine());
		dag = new HashMap<Character,ArrayList<Character>>();
		
		for(int i=0; i<initialNum; i++){
			char[] str = br.readLine().toCharArray();
			prior.remove(str[0]);
			prior.remove(str[2]);
			
			int n = (int)str[0]-65;
			int m = (int)str[2]-65;
			
			
			ArrayList<Character> arr = dag.get(str[0]);
			
			if(arr!=null){
				arr.add(str[2]);
			}else{
				ArrayList<Character> arr2 = new ArrayList<Character>();
				arr2.add(str[2]);
				dag.put(str[0], arr2);
			}
			
			if(alpaBat[n] == -1){
				alpaBat[n] = 0;
			}
			
			if(alpaBat[m] == -1){
				alpaBat[m] = 1;
			}else{
				alpaBat[m] += 1;
			}
		}
		
		solution();
	}
	
	
	private static void solution(){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<alpaBat.length; i++){
			if(alpaBat[i]==0){
				char c = (char)(i+65);
				prior.add(c);
			}
		}
		
		while(prior.size()!=0){
			char n = prior.poll();
			sb.append(n+" ");
			ArrayList<Character> arr = dag.get(n);
			if(arr!=null){
				for(char k:arr){
					int m = (int)k-65;
					alpaBat[m] -= 1;
					if(alpaBat[m]==0){
						prior.add(k);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}


