package tree2.problem_11437_LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이것도 data만 제대로 주면 정답인데.. 얘네들이 순서대로 루트순으로 data를 주는게 아니라,
 * 거꾸로 다르게 data를 주니까 틀린다. 밑에 주석 단 부분경우의 수 때문에 문제(degree 표기하기 어렵다) 표시한 부분때문에 문제다.
 */
public class Main_11437_LCA {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initial = Integer.valueOf(br.readLine());
        Node[] array = new Node[initial+1];
        array[1] = new Node(0,0);
        for(int i=1; i<initial; i++) {
            String[] data = br.readLine().split(" ");
            int node1 = Integer.valueOf(data[0]);
            int node2 = Integer.valueOf(data[1]);

            if(array[node1]!=null){
                array[node2] = new Node(array[node1].dgree+1,node1);
            }else if(array[node2]!=null){
                array[node2] = new Node(array[node1].dgree+1,node1);
            }else{/* 내 로직이 잘못된게 아니라.. data들어오는 순이.. 일정하지 않아요*/
                array[node1] = new Node(-1,node2);
                array[node2] = new Node(-1,node1);
            }
        }

        int l = Integer.valueOf(br.readLine());
        String[] d = new String[l];
        for(int i=0; i<l; i++){
            d[i] = br.readLine();
        }

        solution(array,d);
    }

    private static void solution(Node[] array,String[] data){
        for(int i=0; i<data.length; i++){
            String[] d = data[i].split(" ");
            int leftNode = Integer.valueOf(d[0]);
            int rightNode = Integer.valueOf(d[1]);

            while(array[leftNode] != array[rightNode]){

                if(array[leftNode].dgree > array[rightNode].dgree){
                    leftNode = array[leftNode].parentIndex;
                }else if(array[leftNode].dgree < array[rightNode].dgree){
                    rightNode = array[rightNode].parentIndex;
                }else{
                    leftNode = array[leftNode].parentIndex;
                    rightNode = array[rightNode].parentIndex;
                }
            }

            System.out.println(leftNode);
        }
    }
}

class Node{

    int dgree;
    int parentIndex;

    public Node(int degree,int parentIndex){
        this.dgree = degree;
        this.parentIndex = parentIndex;
    }
}
