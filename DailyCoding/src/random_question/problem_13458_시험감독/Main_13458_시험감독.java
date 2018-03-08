package random_question.problem_13458_시험감독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initialNum = Integer.valueOf(br.readLine());
		long data[] = new long[initialNum];
		int i = 0;
		for(String s : br.readLine().split(" ")){
			data[i++] = Integer.valueOf(s);
		}
		
		String[] k = br.readLine().split(" ");
		long prior = Integer.valueOf(k[0]);
		long minor = Integer.valueOf(k[1]);
		
		solution(data,prior,minor);
	}
	
	private static void solution(long[] data,long prior,long minor){
		long result = 0;
		
		for(long d:data){
			long restPeople = d - prior;
			result += 1;
			if(restPeople<=0){
				continue;
			}else{
				result += (restPeople / minor);
				restPeople %= minor;
				if(restPeople != 0)
					result += 1;
				
			}
		}
		
		System.out.println(result);
	}
}
