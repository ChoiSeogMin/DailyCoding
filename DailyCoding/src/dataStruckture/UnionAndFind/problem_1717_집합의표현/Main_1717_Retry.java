package dataStruckture.unionAndFind.problem_1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main_1717_Retry {
	
	private static int[] parent;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int n = Integer.valueOf(str[0]); //n이하
		parent = new int[n+1];
		for(int i=0; i<n+1; i++){
			parent[i] = i;
		}
		
		int m = Integer.valueOf(str[1]); //m연산의 갯수
		
		for(int i=0; i<m; i++){
			int[] data = getReturnValue(br.readLine().split(" "));
			solution(data[0],data[1],data[2]);
		}
		System.out.println(sb.toString());
	}
	
	private static void solution(int condition, int parent, int son){
		
		if(condition == 1){
			if(find(parent)==find(son))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}else{
			union(parent,son);
		}
	}
	
	/***
	 * parent의 root num을 반환한다.
	 * 반환 하면서, 재귀적인 방법으로, 자식노드의 parent를 root로 변경
	 * @param p
	 * @return
	 */
	private static int find(int p){
		if(p == parent[p]){ //p의 parent와 p값이 같을경우 내가 root다.
			return p;
		}else{
			int root = find(parent[p]);
			parent[p] = root;
			return root;
		}
	}
	/***
	 * parent 즉 root를 찾아서, 자식이 되는 root를, parent의 root에 잇는다.
	 * 위에 find는 분할 경로 압축 방식을 사용했기 때문에, find되는 과정에 자식레벨은 1이 되므로,
	 * 이에 붙여도 다음 find될떄 O(2)에 해당한다.
	 * @param p
	 * @param s
	 */
	private static void union(int p,int s){
		p = find(p);
		s = find(s);
		parent[s] = p;
	}
	
	private static int[] getReturnValue(String[] strData){
		int[] data = new int[strData.length];
		int i = 0;
		for(String s:strData)
			data[i++] = Integer.valueOf(s);
		return data;
	}
}
