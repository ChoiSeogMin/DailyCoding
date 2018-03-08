package dynamicProgramming.problem_2156_포도주시식;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156{

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		long[] data = new long[n+1];
		for(int i=1; i<=n; i++){
			data[i] = Integer.valueOf(br.readLine());
		}
		
		long[] m = new long[n+1];
		
		System.out.println(getResult(data,m));
	}

	private static long getResult(long[] data,long[]m){
		
		m[1] = data[1];
		if(data.length > 2)
			m[2] = data[1] + data[2];
		
		for(int i = 3; i<data.length; i++){
			m[i] = m[i-1];
			m[i] = Math.max(m[i], m[i-2] + data[i]);
			m[i] = Math.max(m[i], m[i-3] + data[i-1] + data[i]);
		}
		
		long result = m[1];
		
		for(int i=2; i<data.length; i++){
			result = Math.max(m[i], result);
		}
		return result;
	}
}