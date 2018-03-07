package tree2.problem_11438_LCA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//문제
//N(2 ≤ N ≤ 100,000)개의 정점으로 이루어진 트리가 주어진다. 트리의 각 정점은 1번부터 N번까지 번호가 매겨져 있으며, 루트는 1번이다.
//두 노드의 쌍 M(1 ≤ M ≤ 100,000)개가 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 출력한다.
//입력 첫째 줄에 노드의 개수 N이 주어지고, 다음 N-1개 줄에는 트리 상에서 연결된 두 정점이 주어진다. 그 다음 줄에는 가장 가까운 공통 조상을 알고싶은 쌍의 개수 M이 주어지고, 다음 M개 줄에는 정점 쌍이 주어진다.
//출력
//M개의 줄에 차례대로 입력받은 두 정점의 가장 가까운 공통 조상을 출력한다.
//Vim 에서 전체 주석 처리하는 방법 모르겠다. norm안먹는데.. Google의 설명은 죄다 이상하다..
public class Main_11438_LCA2_WrongAnswer {

    //1. data Node를 어떻게 표현해 줄 것인가!?
    //2. Data Node의 Degree를 어떻게 Set해줄 것인가!?
    //3. Tree의 개념이 애메한게, 그래프를 표기하는데, 2가지 방법이 있다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initial = Integer.valueOf(br.readLine());
        ArrayList<Integer>[] array = new ArrayList[initial+1];
        for(int i=0; i<array.length; i++){
            array[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<initial-1; i++){
            String[] data = br.readLine().split(" ");
            int n = Integer.valueOf(data[0]);
            int m = Integer.valueOf(data[1]);

            array[n].add(m);
            array[m].add(n);
        }

        int[] depth = new int[initial+1];
        boolean[] check = new boolean[initial+1];
        int[] parent = new int[initial+1];
        parent[1] = 1;
        setDegree(array,depth,check,parent);

        int answerCnt = Integer.valueOf(br.readLine());

        for(int j=0; j<answerCnt; j++){
            String[] data = br.readLine().split(" ");
            int n = Integer.valueOf(data[0]);
            int m = Integer.valueOf(data[1]);

            solution(array,depth,check,parent,n,m);
        }
    }

    private static void setDegree(ArrayList<Integer>[] array,int[] depth,boolean[] check,int[] parent){
        Queue<Integer> queue = new LinkedList<>();
        int start = 1;
        depth[start] = 0;
        check[start] = true;
        queue.add(start);

        while(queue.size() != 0){
            int num = queue.poll();
            for(int k:array[num]){
                if(check[k]==false){
                    check[k] = true;
                    depth[k] = depth[num] + 1;
                    parent[k] = num;
                    queue.add(k);
                }
            }
        }
    }

    private static void solution(ArrayList<Integer>[] array,int[] depth,boolean[] check,int[] parent,int n,int m){

        while(n!=m){
            if(depth[n]>depth[m]){
                n = parent[n];
            }else if(depth[n]<depth[m]){
                m = parent[m];
            }else{
                n = parent[n];
                m = parent[m];
            }
        }

        System.out.println(n);
    }
}
