package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/***
 * 배경지식 최소 스패닝트리
 * Minumum Spanning Tree
 * 스패닝 트리: 그래프에서 이부 간선을 선택해서 만든 트리
 * 최소 스패닝 트리: 스패닝 트리 중에 선택한 간선의 가중치의 합이 최소인 트리
 * 간선중에 최소 스패닝을 어떻게 알 수 있을까? 
 * 
 * 문제중에 알게된사실은 정점과 간선을 리스트로 관리한뒤 차츰차츰 찾을떄 마자 합치는 방식이 좋다.
 * 어디서 출발하여 어디서 end될지는 모른다 하더라도, 하나씩 합친뒤 차츰차츰 찾는 범위를
 * 넓혀나가는게, 처음부터 PriorityQueue에 전부 다담아놓고 찾는 것 보다 훨씬 빠르다.
 * @author 최석민
 *
 */
public class Main_1922_네트워크연결 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		InitialInput input = new InitialInput();
		boolean[] isArriveNode = input.getIsArriveNode();
		PriorityQueue<Edge>[] queue = input.getPriorityQueue();
		solution(isArriveNode,queue);
	}
	
	private static void solution(boolean[] isArriveNode,PriorityQueue<Edge>[] queue){
		int count = isArriveNode.length - 1;
		int minimumCost = 0;
		
		PriorityQueue<Edge> findIndex = new PriorityQueue<Edge>();
		
		isArriveNode[1] = true;//시작은 1
		count--;
		findIndex.addAll(queue[1]);
		int startIndex = 1;
		while(count != 0){
			Edge edge = findIndex.poll();
			if(isArriveNode[edge.start]==false){
				isArriveNode[edge.start]=true;
				count--;
				minimumCost += edge.cost;
				findIndex.addAll(queue[edge.start]);
			}else if(isArriveNode[edge.end]==false){
				isArriveNode[edge.end]=true;
				count--;
				minimumCost += edge.cost;
				findIndex.addAll(queue[edge.end]);
			}
		}
		
		System.out.println(minimumCost);
		
	}
}


class InitialInput{
	boolean[] isArriveNode;
	//동시성에서는 PriorityBlockingQueue<E>
	
	PriorityQueue<Edge>[] queueArray;
	
	public InitialInput() throws NumberFormatException, IOException{//생성자에서도 Exception날릴수 있다는거..
		init();
	}
	
	private void init() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		isArriveNode = new boolean[n+1]; //1 ~ n
		queueArray  = new PriorityQueue[n+1];
		
		for(int i=1; i<queueArray.length; i++){
			queueArray[i] = new PriorityQueue<Edge>();
		}
		for(int i=0; i<m; i++){
			String[] data = br.readLine().split(" ");
			int start = Integer.valueOf(data[0]);
			int end = Integer.valueOf(data[1]);
			int cost = Integer.valueOf(data[2]);
			
			queueArray[start].add(new Edge(start,end,cost));
			queueArray[end].add(new Edge(start,end,cost));
		}
	}
	
	public boolean[] getIsArriveNode(){
		return isArriveNode;
	}
	
	public PriorityQueue<Edge>[] getPriorityQueue(){
		return queueArray;
	}
	
}

class Edge implements Comparable<Edge>{
	
	public int start;
	public int end;
	public int cost;
	
	public Edge(int start,int end,int cost){
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Edge [start=" + start + ", end=" + end + ", cost=" + cost + "]";
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		
		return this.cost - o.cost;
	}
}