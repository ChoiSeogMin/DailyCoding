package dataStruckture.problem_6549_히스토그램에서가장큰직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6549_useStack {

	private static Stack<DiagramData> stack = new Stack<DiagramData>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
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
			sb.append(findMaxRectangle(data));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static long findMaxRectangle(long[] data){
		DiagramData dd = null;
		DiagramData predd = null;
		long maxValue = 0;
		
		for(int i=0; i<data.length; i++){
			if(stack.size()!=0)
				dd = stack.peek();
			else{
				stack.add(new DiagramData(data[i],i));
				continue;
			}
			
			if(dd.height<=data[i]){ 
				stack.add(new DiagramData(data[i],i));
			}else{//stack의 맨위에 dd가 현재 diagram보다 작을때, 즉 stack의 맨위에 diagram은 더이상 직사각형을 그릴 수 없다.
				int right = i-1;//이전거 기준
				int left = -1;
				while(stack.size() !=0){
					dd = stack.pop();
					if(dd.height <= data[i]){
						stack.add(dd);
						break;
					}
					if(stack.isEmpty()){
						left = 0;
						maxValue = Math.max(maxValue,getRectangleArea(right,left,dd.height));
						break;
					}else{
						predd = stack.peek();
						if(dd.height>predd.height){
							left = predd.index + 1;
							maxValue = Math.max(maxValue,getRectangleArea(right,left,dd.height));
						}
					}
				}
				stack.add(new DiagramData(data[i],i));
			}
		}
		
		int left = -1;
		int right = data.length -1;
		while(!stack.isEmpty()){
			dd = stack.pop();
			if(!stack.isEmpty()){
				predd = stack.peek();
				if(dd.height>predd.height){
					left = predd.index;
					maxValue = Math.max(maxValue,getRectangleArea(right,left+1,dd.height));
				}else{//서로 같다.
					continue;
				}
			}else{
				left = 0;
				maxValue = Math.max(maxValue,getRectangleArea(right,left,dd.height));
			}
		}
		
		
		return maxValue;
	}
	
	private static long getRectangleArea(int right,int left, long height){
		
		return (((long)right - (long)left) + 1) * height;
	}
}

class DiagramData{
	public long height;
	public int index;
	
	public DiagramData(long height, int index){
		this.height = height;
		this.index = index;
	}

	@Override
	public String toString() {
		return "DiagramData [height=" + height + ", index=" + index + "]";
	}
}
