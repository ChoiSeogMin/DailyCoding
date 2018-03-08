package graph2.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;


public class Main_1197_최소스패닝트리 {
	/***
	 * 해당문제를 돌리면 시간초과가 난다. 정답의 방식은 맞았지만,
	 * 아마도 HashSet을 합치는 과정에서 너무 많은 부하가 일어나지 않을까 생각한다.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		InputDevice input = new InputDevice();
		
		PriorityQueue<Edge> queue = input.getInitialData();
		int nodeCount = input.getNodeCount();
		
		solution(queue,nodeCount);
	}
	
	private static void solution(PriorityQueue<Edge> queue,int nodeCount){
		Edge edge = queue.poll();
		int result = 0;
		HashSet<Integer>[] array = new HashSet[nodeCount+1]; //array가 node들이 가지고 있는, set이다.
		
		HashSet<Integer> defaultSet = new HashSet<Integer>();
		defaultSet.add(edge.startNode);
		defaultSet.add(edge.endNode);
		array[edge.startNode] = defaultSet;
		array[edge.endNode] = defaultSet;
		result += edge.cost;
		//이게 시작이다.
		int center = edge.startNode;
		while(array[center].size() != nodeCount){
			edge = queue.poll();
			Integer s = edge.startNode;
			Integer e = edge.endNode;
			
			if(array[s]==null && array[e]==null){
				HashSet<Integer> temp = new HashSet<Integer>();
				temp.add(s);
				temp.add(e);
				array[s] = temp;
				array[e] = temp;
				result += edge.cost;
			}else if(array[s]!=null && array[e]==null){
				array[s].add(e);
				array[e] = array[s];
				result += edge.cost;
			}else if(array[s]==null && array[e]!=null){
				array[e].add(s);
				array[s] = array[e];
				result += edge.cost;
			}else{//둘다 null이 아니면
				if(array[s].contains(e)){//같은 집합이니까 넘긴다.
					
				}else{
					array[s].addAll(array[e]);
					array[e] = array[s];
					result += edge.cost;
				}
			}
		}
		
		System.out.println(result);
	}
}


class InputDevice{
	
	PriorityQueue<Edge> queue;
	int nodeCount;
	public PriorityQueue<Edge> getInitialData() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		int v = Integer.valueOf(init[0]);
		int e = Integer.valueOf(init[1]);
		
		nodeCount = v;
		queue = new PriorityQueue<Edge>();
		
		
		for(int i=0; i<e; i++){
			String[] d = br.readLine().split(" ");
			queue.add(new Edge(Integer.valueOf(d[0]),Integer.valueOf(d[1]),Integer.valueOf(d[2])));
		}
		
		return queue;
	}
	
	public int getNodeCount(){
		return nodeCount;
	}
 	
}

class Edge implements Comparable<Edge>{
	
	public int startNode;
	public int endNode;
	public int cost;
	
	public Edge(int startNode,int endNode, int cost){
		this.startNode = startNode;
		this.endNode = endNode;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}
