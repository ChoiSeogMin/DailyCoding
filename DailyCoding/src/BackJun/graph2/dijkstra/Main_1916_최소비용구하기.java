package graph2.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main_1916_최소비용구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		InputDevice inputDevice = new InputDevice();
		inputDevice.initData();
		
		ArrayList<Bus>[] busStops = inputDevice.getArrayList();
		int[] city = inputDevice.getCity();
		int s = inputDevice.getStartNode();
		int e = inputDevice.getFinishNode();
		
		dijkstraSolution(busStops,city,s,e);
	}
	
	private static void dijkstraSolution(ArrayList<Bus>[] busStops,int[] city,int s,int e){
		boolean[] isArriveNode = new boolean[city.length]; //1 ~ n
		int cnt = city.length;
		int[] v = new int[city.length];
		v[s] = -1;
		for(int k=0; k<cnt-1; k++){//시작점에서 출발하면 시작점 한번 들어가면 닿지 않는 곳이 있을지 모른다.
			int x = -1;
			int next = 1000000006; //최소값을 구하기 위해서 이거 만약에 inf값으로 동일하게 설정하면, 아래 for문 안으로 들어가는데 제약사항이 크다. 따라서 어쨋든 다음순서를 정하려면 아래로 들어가야 한다.
			for(int i=1; i<=city.length-1; i++){
				if(isArriveNode[i] == false && next>city[i]){//여기서 처음 city를 0으로 초기화해줬던 값을 찾을 수 있겠구나! 
					x = i;
					next = city[i];
				}
			}
			
			isArriveNode[x] = true;
			
			for(Bus bus:busStops[x]){
				if(city[bus.finishNode] > city[bus.startNode] + bus.cost){
					city[bus.finishNode] = city[bus.startNode] + bus.cost;
					v[bus.finishNode] = bus.startNode;
				}
			}
		}
		
		System.out.println(city[e]);
		findPath(v,e);
	}
	
	 private static void findPath(int[] v,int end){
		 int k = end;
		 Stack<Integer> stack = new Stack<Integer>();
		 
		 while(k != -1){
			 stack.push(k);
			 k = v[k];
		 }
		 
		 System.out.println(stack.size());
		 while(stack.size()!=0){
			 System.out.print(stack.pop()+" ");
		 }
	 }
}

class InputDevice{
	
	ArrayList<Bus>[] arrayList;
	int[] city;
	int startNode;
	int finishNode;
	
	public void initData() throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		city = new int[n+1];//1~n까지
		Arrays.fill(city, 1000000005);
		arrayList = new ArrayList[n+1];
		for(int i=0; i<n+1; i++){
			arrayList[i] = new ArrayList<Bus>();
		}
		
		int cnt = Integer.valueOf(br.readLine());
		for(int i=0; i<cnt; i++){
			String[] d = br.readLine().split(" ");
			int start = Integer.valueOf(d[0]);
			int end = Integer.valueOf(d[1]);
			int cost = Integer.valueOf(d[2]);
			
			Bus bus = new Bus(start,end,cost);
			arrayList[start].add(bus);
		}
		
		String[] data = br.readLine().split(" ");
		startNode = Integer.valueOf(data[0]);
		finishNode = Integer.valueOf(data[1]);
		
		city[startNode] = 0;
	}
	
	public ArrayList<Bus>[] getArrayList(){
		return arrayList;
	}
	
	public int[] getCity(){
		return city;
	}

	public int getStartNode() {
		return startNode;
	}

	public int getFinishNode() {
		return finishNode;
	}
}

