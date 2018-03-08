

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//입력:첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1≤N≤40, |S|≤1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절대값은 100,000을 넘지 않는다. 같은 수가 여러번 주어질 수도 있다.

//출력:첫째 줄에 합이 S가 되는 부분집합의 개수를 출력한다.
//부분집합은 Binary로 구할 수 있다.
//2 ^ 4 -1 = 15인데,
//0001 0010 0100 1000
//0011 0111 ~ 식으로 되기 때문에 + 1을 계속하면서 bitmask를 구해서
//부분집합을 뽑아낼 수 있다.
//& AND연산으로 해당하는 값을 찾아 낼 수 있다. 우와

/** 이건 GOD이다. 어떻게 이렇게 부분집합을 풀 생각을하지?.. ??
 int[] first = new int[1<<n];
 for (int i=0; i<(1<<n); i++) {//전체 경우의 수를 봐야한다. 부분집합의 갯수만큼 보겠다. 2^N 승이다.
    for (int k=0; k<n; k++) {// 조합의 갯수 딱 숫자만큼만 센다.
        if ((i&(1<<k)) == (1<<k)) {
            first[i] += a[k];
        }
    }
 }
 */
public class Main_1208_부분집합의합2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initial = br.readLine().split(" ");
        int n = Integer.valueOf(initial[0]);
        int s = Integer.valueOf(initial[1]);
        int[] data = new int[n];
        int i = 0;

        for(String d:br.readLine().split(" ")){
            data[i++] = Integer.valueOf(d);
        }

        int mid = data.length / 2;
        int[] data1 = Arrays.copyOfRange(data,0,mid);
        int[] data2 = Arrays.copyOfRange(data,mid,data.length);

        solution(getSubset(data1),getSubset(data2),s);

    }

    public static void solution(int[] data1, int[] data2, int s){
        Arrays.sort(data1);
        Arrays.sort(data2);
        long result = 0;
        //공집합 제외
        int i = 0;
        int j = data2.length-1;
        int sum = 0;

        //while절이 언제 까지 돌건지 생각하면 구현하기 한층 더 쉬워진다.
        while(i<data1.length && j>=0){
            sum = data1[i] + data2[j];
            if(sum<s){
                i++;
            }else if(sum>s){
                j--;
            }else{//sum==s
                long icnt = 1;
                long jcnt = 1;
                while(i<data1.length-1){
                    if(data1[i+1]==data1[i]){
                        icnt++;
                        i++;
                    }else break;
                }
                while(j>=1){
                    if(data2[j-1]==data2[j]){
                        jcnt++;
                        j--;
                    }else break;
                }
                result += (icnt * jcnt);
                i++;
                j--;
            }
        }

        if(s==0){
            result--;
        }
        System.out.println(result);

    }

    public static int[] getSubset(int[] data) {

        int num = data.length;
        int[] subSetData = new int[1<<num];

        for(int i=0; i<1<<num; i++){
            for(int j=0; j<data.length; j++){
                if((i&(1<<j))==(1<<j)){
                    subSetData[i] += data[j];
                }
            }
        }
        return subSetData;
    }
}
