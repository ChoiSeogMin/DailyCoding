package dataStruckture.problem_6549_히스토그램에서가장큰직사각형;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProblem_6549 {

	@Test
	public void test() {
		long time = System.currentTimeMillis();
		long[] sampleData = new long[100000];
		for(int i=0; i<100000; i++){
			sampleData[i] = i+1;
		}
		//1 ~ 10000
		//5000 * 5001
		//25005000
		System.out.println(Main_6549.solution(sampleData));
		System.out.println(System.currentTimeMillis() - time);
	}

}
