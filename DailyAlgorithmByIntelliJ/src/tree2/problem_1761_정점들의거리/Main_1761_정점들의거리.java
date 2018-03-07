package tree2.problem_1761_정점들의거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1761_정점들의거리 {

    private static int result = 0;

    //입력 값을 받는다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initial = Integer.valueOf(br.readLine());
        Node[] array = new Node[initial+1];

        for(int i=0; i<array.length; i++){
            array[i] = new Node();
            array[i].edgeCost = new int[initial+1];
        }

        for(int i=0; i<initial-1; i++){
            String[] data = br.readLine().split(" ");
            int n = Integer.valueOf(data[0]);
            int m = Integer.valueOf(data[1]);
            int cost = Integer.valueOf(data[2]);

            array[n].thisNum = n;
            array[n].edgeCost[m] = cost;
            array[n].linkNode.add(array[m]);

            array[m].thisNum = m;
            array[m].edgeCost[n] = cost;
            array[m].linkNode.add(array[n]);
        }

        setDegree(array);
        int initial2 = Integer.valueOf(br.readLine());

        for(int i=0; i<initial2; i++){
            String[] data = br.readLine().split(" ");
            result = 0;
            solution(array,initial2,data);
            System.out.println(result);
        }
    }

    //차수를 설정한다.
    private static void setDegree(Node[] array){

        Queue<Node> queue = new LinkedList<Node>();
        boolean[] checkNode = new boolean[array.length];
        checkNode[1] = true;
        array[1].degree = 1;

        for(int i=0; i<array[1].linkNode.size(); i++){
            Node n =  array[1].linkNode.get(i);
            if(!checkNode[n.thisNum]){
                checkNode[n.thisNum] = true;
                n.degree = 2;
                queue.add(n);
            }
        }

        while(queue.size() != 0){
            Node n = queue.poll();
            for(int j=0; j<n.linkNode.size(); j++){
                Node n2 = n.linkNode.get(j);
                if(!checkNode[n2.thisNum]){
                    checkNode[n2.thisNum] = true;
                    n2.degree = n.degree + 1;
                    queue.add(n2);
                }
            }
        }

    }

    //문제 해결 방법
    private static int solution(Node[] array,int initial2,String[] data){

        int n = Integer.valueOf(data[0]);
        int m = Integer.valueOf(data[1]);

        while(n!=m){

            if(array[n].degree>array[m].degree){
                n = findNextDegree(array[n]);
            }else if(array[m].degree>array[n].degree){
                m = findNextDegree(array[m]);
            }else{
                n = findNextDegree(array[n]);
                m = findNextDegree(array[m]);
            }

        }

       return n;
    }

    private static int findNextDegree(Node n){

        for(int i=0; i<n.linkNode.size(); i++){
            int degree = n.linkNode.get(i).degree;
            if(n.degree > degree){
                int nextIndex = n.linkNode.get(i).thisNum;
                result += n.edgeCost[nextIndex];
                return nextIndex;
            }
        }
        return -1;
    }
}

class Node{

    ArrayList<Node> linkNode = new ArrayList<>();
    int thisNum;
    int degree;
    int[] edgeCost;

}
