package random_question.problem_2003_수들의합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2003 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initialData = br.readLine().split(" ");
        int l = Integer.valueOf(initialData[0]);
        long k = Long.valueOf(initialData[1]);
        long[] data = new long[l];
        int i = 0;
        for(String d:br.readLine().split(" ")){
            data[i++] = Long.valueOf(d);
        }

        solution(data,k);

    }

    private static void solution(long[] data,long k){

        int i = 0;
        int j = -1;
        int result = 0;
        long sum = data[i];
        while(true) {

            if (sum == k) {
                result++;
                if(i+1<data.length) {
                    i++;
                    sum += data[i];
                }else if(j+1<data.length){
                    j++;
                    sum -= data[j];
                }else{
                    break;
                }
            }else if(sum > k){
                if(j+1<data.length){
                    j++;
                    sum -= data[j];
                }
                else break;
            }else if(sum < k){
                if(i+1<data.length){
                    i++;
                    sum += data[i];
                }
                else break;
            }
        }

        System.out.println(result);
    }
}
