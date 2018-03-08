import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {
    //입력: 첫째 줄에 N (10 < N < 100,000)과 S (0 < S < 100,000,000)가 주어진다. 둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.
    //출력: 첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0;
        long s = 0;
        while(st.hasMoreTokens()){
            n = Integer.valueOf(st.nextToken());
            s = Long.valueOf(st.nextToken());
        }

        int[] data = new int[n];
        int i =0;
        for(String str:br.readLine().split(" ")){
            data[i++] = Integer.valueOf(str);
        }

        System.out.println(solution(data,s));
    }

    public static long solution(int[] data,long s){
        int i = 0;
        int j = 0;
        long sum = 0;
        long result = 0;
        while(true){
            if(sum >= s){
                if(result == 0){
                    result = i-(j+1)+1;
                }else{
                    result = Math.min(result,i-(j+1)+1);
                }
                if(j<data.length)
                    sum -= data[j++];
                else break;
            }else if(sum < s){
                if(i<data.length)
                    sum += data[i++];
                else break;
            }
        }

        return result;
    }

}
