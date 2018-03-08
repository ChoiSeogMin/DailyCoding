package graph2.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1504_특정한최단경로 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] d = br.readLine().split(" ");
		int n = Integer.valueOf(d[0]);
		int k = Integer.valueOf(d[1]);
		
		long[] city = new long[n+1];
		boolean[] isArrive = new boolean[n+1];
		
		Arrays.fill(city, 100000000);
		city[1] = 0;//첫번쨰 도시에서 시작
		
		ArrayList<Bus2>[] arrays = new ArrayList[n+1];
		
		for(int i=0; i<arrays.length; i++){
			arrays[i] = new ArrayList<Bus2>();
		}
		
		for(int i=0; i<k; i++){
			String[] data = br.readLine().split(" ");
			int s = Integer.valueOf(data[0]);
			int e = Integer.valueOf(data[1]);
			int cost = Integer.valueOf(data[2]);
			//양방향이기 때문에
			arrays[s].add(new Bus2(s,e,cost));
			arrays[e].add(new Bus2(e,s,cost)); 
		}
		
		String[] data = br.readLine().split(" ");
		int f = Integer.valueOf(data[0]);//반드시 거쳐야할 노드 //f를 가면, 처음 ~f + f2부터 목적지 + f까지 + f~f2구간
		int f2 = Integer.valueOf(data[1]);//반드시 거쳐야할 노드//f2를 먼저가면 ,처음~f2 + f부터 목적지 + f2~f구간

		city = solution(arrays,city,isArrive);
		long via = city[f];
		long via2 = city[f2];
		
		Arrays.fill(city, 1000000000);
		Arrays.fill(isArrive,false);
		city[f] = 0;
		city = solution(arrays,city,isArrive);
		long lastf = city[n];
		long center = city[f2];
		
		Arrays.fill(city, 1000000000);
		Arrays.fill(isArrive,false);
		city[f2] = 0;
		city = solution(arrays,city,isArrive);
		long lastf2 = city[n];
		long center2 = city[f];
		
		if(via + center + lastf2 > via2 + center2 + lastf){
			if(via2 + center2 + lastf > 1000000000){
				System.out.println(-1);
			}else{
				System.out.println(via2 + center2 + lastf);
			}
		}else{
			if(via + center + lastf2 > 1000000000){
				System.out.println(-1);
			}else{
				System.out.println(via + center + lastf2);	
			}
		}
		
	}
	
	private static long[] solution(ArrayList<Bus2>[] arrays, long[] city, boolean[] isArrive){
		long temp = 1000000005;
		int nextIndex = -1;//방문 index
		for(int k = 1; k<city.length; k++){
			for(int n=1; n<city.length; n++){
				
				if(city[n]<temp && isArrive[n]==false){
					nextIndex = n;
					temp = city[n];
				}
			}
			
			temp = 1000000005;//최소 index찾았으니 temp값은 원상복귀
			isArrive[nextIndex] = true;//for문을 빠져나오면 방문함
			
			for(Bus2 bus:arrays[nextIndex]){
				if(city[bus.endIndex]>city[bus.startIndex]+bus.cost){//이건 사실상 bfs와 같다.
					city[bus.endIndex] = city[bus.startIndex]+bus.cost;
				}
			}
		}
		
		return city;
		
	}
}

class Bus2{
	
	int startIndex;
	int endIndex;
	int cost;
	
	public Bus2(int s,int e,int c){
		this.startIndex = s;
		this.endIndex = e;
		this.cost = c;
	}

	@Override
	public String toString() {
		return "Bus2 [startIndex=" + startIndex + ", endIndex=" + endIndex + ", cost=" + cost + "]";
	}
}
