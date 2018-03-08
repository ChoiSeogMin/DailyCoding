package dataStruckture.unionAndFind.problem_2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2606 {

	
	private static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		parent = new int[n+1];
		for(int i=0; i<n+1; i++){
			parent[i] = i;
		}
		int m = Integer.valueOf(br.readLine());
		int j = 0;
		for(int i=0; i<m; i++){
			int[] input = new int[2];
			j = 0;
			for(String data:br.readLine().split(" ")){
				input[j++] = Integer.valueOf(data);
			}
			
			union(input[0],input[1]);
		}
		
		printAnswer();
	}
	//1번 컴퓨ㅓㅌ가 윔바이러스에 걸렸을떄, 1번 컴퓨터를 통해 윔 바이러스에 걸리게 되는 컴퓨터의 수를 찾아 첫쨰줄에 출력
	private static void printAnswer(){
		int oneComputerRoot = find(1);
		int sum = 0;
		for(int i=1; i<parent.length; i++){
			if(find(i)==oneComputerRoot){
				sum++;
			}
		}
		System.out.println(--sum);
	}
	
	private static int find(int p){
		if(p == parent[p])
			return p;
		else{
			int root = find(parent[p]);
			parent[p] = root;//경로 압축
			return root;
		}
	}
	
	private static void union(int p,int s){
		p = find(p);
		int sRoot = find(s);
		parent[sRoot] = p;
	}
}
