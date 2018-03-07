package divideAndConquer.problem_2261_가장가까운두점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2261_가장가까운두점 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initial = Integer.valueOf(br.readLine());

        ArrayList<Pair> array = new ArrayList<>();
        String[] input = null;
        for(int i=0; i<initial; i++){
            input = br.readLine().split(" ");
            array.add(new Pair(Integer.valueOf(input[0]),Integer.valueOf(input[1])));
        }

        Collections.sort(array);
        System.out.println(getLowDistance(0, array.size(), array));
    }


    public static long getLowDistance(int start, int end, ArrayList<Pair> array){

        ArrayList<Pair> arr = new ArrayList<Pair>();
        int n = end - start + 1;
        if(n<=10){
            return getDistance(start,end,array);
        }
        int mid = (start + end) / 2;
        long left = getLowDistance(start,mid,array);
        long right = getLowDistance(mid+1, end, array);

        long min = Math.min(left,right);

        for(int i=start; i<end; i++){
            long d = array.get(i).x - array.get(mid).x;
            if(d * d < min){
                arr.add(array.get(i));
            }
        }

        Collections.sort(arr);
        long min2 = getDistance(0,arr.size(),arr);

        return Math.min(min,min2);
    }

    public static long getDistanceFromMid(int mid,long minDistance, String direct, ArrayList<Pair> array){

        return minDistance;
    }

    public static long getDist(Pair p, Pair p2){

        long dist = (p.x - p2.x) * (p.x - p2.x) + (p.y - p2.y) * (p.y - p2.y);
        return dist;
    }

    public static long getDistance(int start,int end, ArrayList<Pair> array){

        long minimumDistance = 100000000000000l;
        Pair s = null;
        Pair e = null;
        for(int i=start; i<end; i++){
            s = array.get(i);
            for(int j=i+1; j<end; j++){
                e = array.get(j);
                long thisMinDistance = getDist(s,e);
                minimumDistance = Math.min(minimumDistance,thisMinDistance);
            }
        }

        return minimumDistance;
    }
}

class Pair implements Comparable<Pair>{

    int y;
    int x;

    public Pair(int x,int y){
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Pair o) {
        return this.x - o.x;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
