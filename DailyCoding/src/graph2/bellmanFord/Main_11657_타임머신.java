package graph2.bellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/***
 * big(o)는 간선의 갯수 city개 한번도 검증 + 1 * 간선 갯수이므로
 * E * V라 할 수 있다.
 * e ( u,v,c) e<v^2 도착지 다 가도 간선 갯수가 도착지 제곱을 넘을 수 없을테니
 * 어쨋든 빅오는 e * v 다.
 * @author 최석민
 *
 */
public class Main_11657_타임머신 {

	public static void main(String[] args) throws IOException{
		Solution_11657 solution = new Solution_11657();
		StringBuilder result = solution.getResult();
		System.out.println(result.toString());
	}
}


class Solution_11657{
	int[] city;
	ArrayList<Bus>[] array;
	
	public Solution_11657() throws IOException{
		init();
	}
	
	private void init() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data =br.readLine().split(" ");
		int n = Integer.valueOf(data[0]);
		
		city = new int[n+1]; //해당 도시까지 가는데 비용을 계산하곘다. 
		Arrays.fill(city, -100000000);
		city[1] = 0; //시작 도시는 0이다.
		array = new ArrayList[n+1];
		
		for(int i =0; i<array.length; i++){
			array[i] = new ArrayList<Bus>();
		}
		
		int m = Integer.valueOf(data[1]);
		for(int i=0; i<m; i++){
			String[] d = br.readLine().split(" ");
			int start = Integer.valueOf(d[0]);
			int end = Integer.valueOf(d[1]);
			int cost = Integer.valueOf(d[2]);
			
			Bus bus = new Bus(start,end,cost);
			array[start].add(bus);
		}
	}
	
	public StringBuilder getResult(){
		
		StringBuilder sb = new StringBuilder();
		boolean[] isSetData = new boolean[array.length];
		
		for(int k=0; k<city.length; k++){//정점의 갯수 + 1만큼 돌아야 된다. 그래야 cycle을 확인할수 있다. 마지막에 도는데 값이 변경되면 cycle이 존재한다는 말이기 떄문
			for(int i=1; i<array.length; i++){//array는 간선의 숫자다.
				for(int j=0; j<array[i].size(); j++){//간선 갯수만큼 돌겠다.
					Bus bus = array[i].get(j);
					if(city[bus.startCity]==-100000000)
						continue;
					if(city[bus.arriveCity]==-100000000){
						city[bus.arriveCity] = bus.time + city[bus.startCity];
					}else{
						if(city[bus.arriveCity]>bus.time + city[bus.startCity]){
							city[bus.arriveCity] = bus.time + city[bus.startCity];
							if(k==city.length-1){//cycle이 존재하는지 정점만큼 다 돌았는데 또 변경된건에 들어왔다는 거 자체가 cycle이 존재한다는 뜻임.
								sb.append("-1\n");
								return sb;
							}
						}
					}
				}
			}
		}
		
		for(int i=1; i<city.length; i++){
			if(i!=1){
				if(city[i]!=-100000000)
					sb.append(city[i]+"\n");
				else
					sb.append("-1\n");
			}
		}
		
		return sb;
	}
}

class Bus{
	
	int startCity;
	int arriveCity;
	int time;
	
	public Bus(int startCity, int arrvieCity, int time){
		this.startCity = startCity;
		this.arriveCity = arrvieCity;
		this.time = time;
	}
}