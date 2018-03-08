package dataStruckture.problem_3111_검열;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main_3111_Retry {

	public static void main(String[] args){
		Deque<Character> deque = new LinkedList<Character>();
		Queue<Character> que = new LinkedList<Character>();
		long time = System.currentTimeMillis();
		//** 100만개까지는 자료구조 좋다.  300만개 < 2초, queue든 deque든 성능 차이 거의 없다.  
		//** 1000만개 까지는 delay너무 오래걸림
		
		System.out.println(System.currentTimeMillis()-time);
	}
}
