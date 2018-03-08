package random_question.problem_우형_2번문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_02_괄호자르기 {
    private static ArrayList<Pair> oneArr = new ArrayList<Pair>();
    private static Queue<Pair> notCompleteArray = new LinkedList<Pair>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            startMethod(x1,x2);
        }
        startMethod(-1,2000000000);
        Collections.sort(oneArr);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<oneArr.size(); i++) {
            if(i==0) {
                sb.append(oneArr.get(i).toString().replaceAll("-1", "--") + "\n");
            }else if(i==oneArr.size()-1) {
                sb.append(oneArr.get(i).toString().replaceAll("2000000000", "++") + "\n");
            }else {
                sb.append(oneArr.get(i).toString()+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    private static void startMethod(int x1, int x2) {

        Pair p2 = null;
        Pair p1 = null;
        boolean isCommon = false;
        notCompleteArray.add(new Pair(x1 ,x2));
        while(notCompleteArray.size() != 0) {
            p2 = notCompleteArray.remove();
            isCommon = false;

            for(int j=0; j<oneArr.size(); j++) {
                p1 = oneArr.get(j);
                if(isCommonAre(p1,p2)) {
                    Pair s = firstGetCommonArea(p1.x1,p2.x1);
                    Pair e = secondGetCommonArea(p1.x2, p2.x2);
                    oneArr.remove(j);
                    j-=1;
                    if(s!=null)
                        notCompleteArray.add(s);
                    if(e!=null)
                        notCompleteArray.add(e);
                    isCommon = true;
                    break;
                }
            }
            if(!isCommon)
                oneArr.add(p2);
        }
    }
    public static boolean isCommonAre(Pair p1, Pair p2) {
        if(p1.x2< p2.x1)
            return false;
        if(p2.x2 < p1.x1)
            return false;
        return true;
    }

    public static Pair firstGetCommonArea(int p1x, int p2x) {
        if(p1x == p2x)
            return null;
        int start = Math.min(p1x, p2x);
        int end = Math.max(p1x,p2x) - 1;
        return new Pair(start,end);
    }

    public static Pair secondGetCommonArea(int p1x, int p2x) {
        if(p1x == p2x)
            return null;
        int start = Math.min(p1x, p2x) + 1;
        int end = Math.max(p1x,p2x);
        return new Pair(start,end);
    }
}
class Pair implements Comparable{
    public int x1;
    public int x2;
    public Pair(int x1,int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
    @Override
    public String toString() {
        return "Pair [x1=" + x1 + ", x2=" + x2 + "]";
    }
    @Override
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        Pair o = (Pair) arg0;
        return this.x1 - o.x1;
    }
}
