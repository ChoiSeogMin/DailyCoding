package graph2.dag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1516_게임개발 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		InputDevice_1516 input = new InputDevice_1516();
		Building[] buildings = input.getBuilding();
		int[] preBuildCount = input.getPreBuildCount();
		
		solution(buildings,preBuildCount);
	}
	
	private static void solution(Building[] buildings,int[] preBuildCount){
		Queue<Building> queue = new LinkedList<>();
		
		for(int i=1; i<preBuildCount.length; i++){
			if(preBuildCount[i]==0){
				queue.add(buildings[i]);
			}
		}
		
		while(queue.size() != 0){
			Building building = queue.poll();
			ArrayList<Building> arr = building.arr;			
			for(Building build:arr){
				if(build.preBuildingTime == 0){
					build.preBuildingTime = building.buildingTime + building.preBuildingTime;
				}else{
					build.preBuildingTime = Math.max(build.preBuildingTime, building.buildingTime + building.preBuildingTime);
				}
				preBuildCount[build.order] -= 1;
				if(preBuildCount[build.order]==0){
					queue.add(build);
				}
			}
		}
		
		printResult(buildings);
	}
	
	private static void printResult(Building[] buildings){
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<buildings.length; i++){
			sb.append(buildings[i].buildingTime + buildings[i].preBuildingTime +"\n");
		}
		
		System.out.println(sb.toString());
	}
}

class InputDevice_1516{
	
	Building[] buildings;
	int[] preBuildCount;
	
	public InputDevice_1516() throws NumberFormatException, IOException{
		
		init();
	}
	
	private void init() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		buildings = new Building[n+1];
		for(int i=1; i<n+1; i++){
			buildings[i] = new Building(i);
		}
		preBuildCount = new int[n+1];
		
		String[] data = null;
		for(int i=1; i<n+1; i++){
			data = br.readLine().split(" ");
			preBuildCount[i] = data.length - 2;
			
			for(int j=0; j<data.length-1; j++){
				if(j==0){
					buildings[i].buildingTime = Integer.valueOf(data[j]);
					continue;
				}
				
				int num = Integer.valueOf(data[j]);
				buildings[num].addBuilding(buildings[i]);
			}
		}
	}
	
	public int[] getPreBuildCount(){
		return preBuildCount;
	}
	
	public Building[] getBuilding(){
		return buildings;
	}
}

class Building{
	int order;
	int buildingTime;
	int preBuildingTime;
	ArrayList<Building> arr = new ArrayList<Building>();
	
	public Building(int order){
		this.order = order;
	}
	
	public void addBuilding(Building building){
		arr.add(building);
	}

	@Override
	public String toString() {
		return "Building [order=" + order + ", buildingTime=" + buildingTime + ", preBuildingTime=" + preBuildingTime
				+"]";
	}
}
