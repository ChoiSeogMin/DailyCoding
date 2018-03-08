package random_question.problem_14499_주사위굴리기;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class TestProblem_14499_주사위굴리기 {
	
	@Test
	public void test() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		int[] data1 = {6,3,4,5,2,1};
		int[] data2 = {6,3,4,5,2,1};
		int[] data3 = {6,3,4,5,2,1};
		int[] data4 = {6,3,4,5,2,1};
		
		Class c = Main_14499_주사위굴리기.class;
		Object o = c.newInstance();
		Method testMethod = c.getDeclaredMethod("rollingJusawi", new Class[]{int.class,int[].class});
		testMethod.setAccessible(true);
		int[] result = (int[])testMethod.invoke(o,new Object[]{1,data1});
		for(int i=0; i<result.length; i++){
			System.out.print(result[i]);
		}
		System.out.println();
		
		//1 동 2 서 3 북 4 남 5 나가리
		//6 3 4 5 2 1
		//3 1 6 5 2 4 -> 동쪽
	 	//4 6 1 5 2 3 -> 서쪽
		//5 3 4 1 6 2 -> 북쪽
		//2 3 4 6 1 5 -> 남쪽
	}
}
