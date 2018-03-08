package dataStruckture.problem_6549_히스토그램에서가장큰직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main_6549 {

	private static Deque<Diagram> deque = new LinkedList<Diagram>();
	private static long maxValue = 0;//최대값을 셀 변수.
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
		String[] strData = br.readLine().split(" ");
		if(strData[0].equals("0"))
			break;
		long[] data = null;
		for(int i=0; i<=Integer.valueOf(strData[0]); i++){
			if(i==0){
				data = new long[Integer.valueOf(strData[0])];
			}else{
				data[i-1] = Long.valueOf(strData[i]);
			}
		}
		
		sb.append(solution(data));
		sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static long solution(long[] data){
		
		boolean isSame = false;
		
		for(int i=0; i<data.length; i++){
			int quelen = deque.size();
			for(int j=0; j<quelen; j++){
				//que에서 갯수만큼 다 뽑아서 다시 밀어 넣든 max을 갱신한다.
				Diagram diagram = deque.removeFirst();//앞에서 뽑고 뒤에 밀어 넣자.
				if(!isPossibleMax(diagram.height))//불가능하면 뽑고 다음꺼 100000 개 기준 있을때 60초 내외 뺴면 80초 
					continue;
				
				if(data[i]>diagram.height){
					diagram.leng += 1;
					diagram.index += 1;
					maxValue = Math.max(maxValue, diagram.height * diagram.leng);
					deque.addLast(diagram);
				}else if(data[i]<diagram.height){
					diagram.leng += 1;
					diagram.height = data[i];
					maxValue = Math.max(maxValue, diagram.height * diagram.leng);
					deque.addLast(diagram);
				}else{//같은게 하나라도 있다면?
					diagram.leng += 1;
					diagram.height = data[i];
					maxValue = Math.max(maxValue, diagram.height * diagram.leng);
					deque.addLast(diagram);
					isSame = true;
				}
			}
			
			if(!isSame){//높이가 같았는지 확인 //아니면 1자리를 넣는다.
				maxValue = Math.max(1*data[i], maxValue);
				deque.addLast(new Diagram(data[i],1,i));
			}
			isSame = false;
		}
		
		return maxValue;
	}
	
	public static boolean isPossibleMax(long height){
		
		long possibleMaxValue = height * 100000;
		if(possibleMaxValue > maxValue){
			return true;
		}
		return false;
	}
}

class Diagram{
	
	public long height;
	public long leng;
	public int index;
	
	public Diagram(long height,long leng,int index){
		this.height = height;
		this.leng = leng;
		this.index = index;
	}
}

