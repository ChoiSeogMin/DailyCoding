package codility.Fish;

import java.util.Stack;

public class Fish {

    public static int solution(int[] A,int[] B){

        Stack<Integer> stack = new Stack<>();

        int cnt = 0;

        for (int i=0; i<A.length; i++) {
            if (B[i] == 0) {
                while(stack.size()!=0){//윗물고기들이 있다면
                    int upstreamFish = stack.pop();
                    if(A[i] < upstreamFish){
                        A[i] = -1; //윗물고기한테 잡아 먹힘
                        stack.add(upstreamFish);
                        break;
                    }else{
                        continue;
                    }
                }
            } else { //1
                stack.add(A[i]);
                A[i] = -1;
                //1이면 스택에 담는다.
            }
        }

        for(int k : A){
            if (k != -1) {
                cnt++;
            }
        }
        //윗물고기 아랫물고기
        return cnt + stack.size();
    }
}
