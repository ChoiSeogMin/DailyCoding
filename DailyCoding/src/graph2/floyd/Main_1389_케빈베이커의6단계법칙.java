package graph2.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/***
 * 플로이드는, 모든점에서, 한점을 기준으로
 * 다른 모든 점과의 최소 간선의 비용구하는데 아주 유용한
 * 그래프이다. (minus를 제외하고) 케빈배이컨과같은
 * 문제가 같이 플로이드가 유용한 경우가 많다.
 * @author 최석민
 *
 */
public class Main_1389_케빈베이커의6단계법칙 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] d = br.readLine().split(" ");
		
		int n = Integer.valueOf(d[0]);
		int m = Integer.valueOf(d[1]);
		
		int[][] data = new int[n][n];
		
		for(int i=0; i<m; i++){
			String[] line = br.readLine().split(" ");
			data[Integer.valueOf(line[0])-1][Integer.valueOf(line[1])-1] = 1;
			data[Integer.valueOf(line[1])-1][Integer.valueOf(line[0])-1] = 1;
		}//케빈 베이컨 찾는 문제
		
		solution(data);
	}
	
	private static void solution(int[][] data){
		
		for(int k=0; k<data.length; k++){
			for(int i=0; i<data.length; i++){
				for(int j=0; j<data.length; j++){
					if(i==j)
						continue;
					if(data[i][k]!=0 && data[k][j]!=0){//뭔가 data가 있으면,
						if(data[i][j]==0){
							data[i][j] = data[i][k] + data[k][j];
						}else{
							if(data[i][j]>data[i][k] + data[k][j]){
								data[i][j] = data[i][k] + data[k][j];
							}
						}
					}
				}
			}
		}
		getResult(data);
	}
	
	private static void printdata(int[][] data){
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length; j++){
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void getResult(int[][] data){
		
		int result = 100000000;
		int realResult = -1;
		for(int i=0; i<data.length; i++){
			int kevin = 0;
			for(int j=0; j<data.length; j++){
				kevin += data[i][j];
			}
			if(result>kevin){
				result = kevin;
				realResult = i+1;
			}else if(result == kevin){//번호가 작은애
				if(realResult > i+1){
					realResult = i+1;
				}
			}
		}
		
		System.out.println(realResult);
	}
}
