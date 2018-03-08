package graph2.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1197_최소스패닝_unionFind {
	/**
	 * 그룹을 찾는 문제는 앞에서와 같이 hashSet으로 찾는 문제도 있지만.. 일반적으로
	 * unionAndFind와 같은 root_node를 찾음으로서도 가능하다.. 
	 * 집합을 생각할때 집합의 값이 정수라면,
	 * HashSet말고도 find and Union 방법을 생각하면 더 효율적으로 풀 수 있는
	 * 문제들이 많다고 생각한다.
	 * @param args
	 * @throws IOException 
	 */
	
	private static int[] parent;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] d = br.readLine().split(" ");
		parent = new int[Integer.valueOf(d[0]+1)];
		
		for(int i=0; i<parent.length; i++){
			parent[i] = i;
		}
		
		PriorityQueue<Edge2> prior = new PriorityQueue<Edge2>();
		
		int v = Integer.valueOf(d[1]);
		for(int i=0; i<v; i++){
			String[] data = br.readLine().split(" ");
			prior.add(new Edge2(Integer.valueOf(data[0]),Integer.valueOf(data[1]),Integer.valueOf(data[2])));
		}
		
		solution(prior);
	}
	
	private static void solution(PriorityQueue<Edge2> prior){
		int result = 0;
		Edge2 edge = null;
		while(prior.size() != 0){

			edge = prior.poll();
			int m = find(edge.start);
			int n = find(edge.end);
			
			if(m!=n){
				result += edge.cost;
				union(m,n);
			}
		}
		System.out.println(result);
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

class Edge2 implements Comparable<Edge2>{
	int start;
	int end;
	int cost;
	
	public Edge2(int start,int end,int cost){
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge2 o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}