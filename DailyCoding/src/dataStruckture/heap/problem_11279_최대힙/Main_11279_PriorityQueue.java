package dataStruckture.heap.problem_11279_최대힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11279_PriorityQueue {
	private static PriorityQueue<Data> priorityQueue = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		int data[] = new InputDevice().getInitialData();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<data.length; i++){
			if(data[i]==0){
				if(priorityQueue.size()==0)
					sb.append(0+"\n");
				else
					sb.append(priorityQueue.poll().num+"\n");
			}else{
				priorityQueue.add(new Data(data[i]));
			}
		}
		System.out.println(sb.toString());
		
	}
}

class Data implements Comparable<Data>{
	int num;
	
	public Data(int num){
		this.num = num;
	}
	
	/***
	 * A<B  this는 A에 해당한다. A-B<0을 생각하면 훨씬 쉽다.
	 */
	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
		return o.num-this.num;
	}
}
