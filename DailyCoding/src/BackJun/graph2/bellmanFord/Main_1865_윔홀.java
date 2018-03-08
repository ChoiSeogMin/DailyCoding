
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/***
 * 도시 갯수 500 도로갯수 2500 윔홀 200 cost값 -10000 ~ 0 ~ 10000
 * 500 * 200 * -10000 만해도 -100000000 이 넘어가므로 infi값을 -100000000로 하는건 부적합했다.
 * 차라리 큰숫자로 해버리면, 더이상 안보겠다는 말이니까.. 사실 long으로 하는게 제일 편하다 하겠다.
 * 왠만하면 큰숫자로 하자 cycle을 찾기위해선, 큰숫자로 하면, 초기값이 0이니까 큰숫자는 왠만하면 치환되고
 * 큰수자라서 사이클을 돌아도(값이 게속 자아지는 cycle이도 벨만포드는 음수를 보려고 쓰는 그래프니까)
 * 영향이 없다. 벨만포드의 infi는 100000000로 하자.
 * @author 최석민
 *
 */
public class Main_1865_윔홀 {

	private static int[] city;
	private static ArrayList<Road>[] roads;
	private static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		
		
		for(int i = 0; i<t; i++){
			String[] data = br.readLine().split(" ");
			
			city = new int[Integer.valueOf(data[0])+1]; //1~n
			Arrays.fill(city, 100000000);
			city[1] = 0;
			
			roads = new ArrayList[city.length]; //1~n
			for(int h=0; h<city.length; h++){
				roads[h] = new ArrayList<Road>();
			}//road들 초기화
			int m = Integer.valueOf(data[1]);
			int w = Integer.valueOf(data[2]);
			
			for(int j=0; j<m; j++){
				String[] d = br.readLine().split(" ");
				int s = Integer.valueOf(d[0]);
				int e = Integer.valueOf(d[1]);
				int c = Integer.valueOf(d[2]);
				
				roads[s].add(new Road(s,e,c));
				roads[e].add(new Road(e,s,c));
			}
			
			for(int k=0; k<w; k++){
				String[] d = br.readLine().split(" ");
				int s = Integer.valueOf(d[0]);
				int e = Integer.valueOf(d[1]);
				int c = Integer.valueOf(d[2]);
				
				roads[s].add(new Road(s,e,-c));
			}
			
			solution();
		}
	}
	
	private static void solution(){
		
		boolean isFirstNodeDecrease = false;
		
		for(int i=0; i<city.length; i++){
			for(int j=1; j<roads.length; j++){
				for(int k=0; k<roads[j].size(); k++){
					Road road = roads[j].get(k);
					if(road.startNode != 100000000){
						if(city[road.endNode]==100000000){
							city[road.endNode] = city[road.startNode]+road.cost;
							continue;
						}
						if(city[road.startNode]!=100000000 && city[road.endNode]>(city[road.startNode]+road.cost)){
							city[road.endNode] = city[road.startNode]+road.cost;
							if(i==city.length-1){
								isFirstNodeDecrease = true;
							}
						}
					}
				}
			}
		}
		
		if(isFirstNodeDecrease){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}

class Road{
	public int startNode;
	public int endNode;
	public int cost;
	
	public Road(int startNode, int endNode, int cost){
		this.startNode = startNode;
		this.endNode = endNode;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Road [startNode=" + startNode + ", endNode=" + endNode + ", cost=" + cost + "]";
	}
}
