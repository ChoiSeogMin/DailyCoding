package dataStruckture.unionAndFind.problem_1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/**
 * 논리는 맞았지만, 기본적으로 자바의 Collection객체를 쓰면 느리다.
 * UnionFind문제는 잘 구현에서 일일이 찾아봐라는 식의 문제가 아니다.
 * @author 최석민
 *
 */
public class Main_1717_WrongAnswer{

	private static ArrayList<Number> list;
	private static StringBuilder sb = new StringBuilder();
	private static HashSet<Number> arriveSet;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int n = Integer.valueOf(str[0]); //n이하
		list = new ArrayList<>(n+1);
		for(int i=0; i<n+1; i++){
			list.add(new Number(i)); // 0 ~ n 
		}
		
		int m = Integer.valueOf(str[1]); //m연산의 갯수
		
		for(int i=0; i<m; i++){
			int[] data = getReturnValue(br.readLine().split(" "));
			arriveSet = new HashSet<>();
			if(!findValue(data[0],data[1],data[2])){
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	
	private static boolean findValue(int condition,int index,int value){	
		
		if(condition == 0){//add
			Number num = list.get(index);
			num.getSet().add(list.get(value));
			
			Number valNum = list.get(value);
			valNum.getSet().add(list.get(index));
			return true;
		}else{//판단
			Number num = list.get(index);
			arriveSet.add(num);//방문
			
			if(num.getSet().contains(list.get(value))){
				sb.append("YES\n");
				return true;
			}else{
				Iterator<Number> it = num.getSet().iterator();
				while(it.hasNext()){
					Number findIndex = it.next();
					if(!arriveSet.contains(findIndex)){
						if(findValue(condition,findIndex.value,value)){
							return true;
						}
					}
				}
				return false;
			}
		}
	}
	
	private static int[] getReturnValue(String[] strData){
		int[] data = new int[strData.length];
		int i = 0;
		for(String s:strData)
			data[i++] = Integer.valueOf(s);
		return data;
	}
}

class Number{
	
	HashSet<Number> set = null;
	int value;
	
	public Number(int value){
		this.value = value;
		this.set = new HashSet<>();
	}

	public HashSet<Number> getSet() {
		return set;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Number [set=" + set + ", value=" + value + "]";
	}
}
