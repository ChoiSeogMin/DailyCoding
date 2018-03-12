package problem_10430_나머지구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * �ִ� �״�� Ǭ��.
 * ù° �ٿ� (A+B)%C, ��° �ٿ� (A%C + B%C)%C, ��° �ٿ� (A��B)%C, ��° �ٿ� (A%C �� B%C)%C�� ����Ѵ�.
 * @author �ּ���
 *
 */
public class Main_10430 {

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		int[] dataNum = new int[3];
		for(String data:br.readLine().split(" ")){
			dataNum[i++] = Integer.valueOf(data);
		}
		
		System.out.println((dataNum[0]+dataNum[1]) %dataNum[2]);
		System.out.println((dataNum[0]%dataNum[2]+dataNum[1]%dataNum[2])%dataNum[2]);
		System.out.println((dataNum[0]*dataNum[1]) %dataNum[2]);
		System.out.println((dataNum[0]%dataNum[2])*(dataNum[1]%dataNum[2])%dataNum[2]);
		
	}
}
