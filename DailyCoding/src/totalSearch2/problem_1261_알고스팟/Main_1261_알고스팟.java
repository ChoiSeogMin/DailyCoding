
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1261_알고스팟 {


    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initial = br.readLine().split(" ");
        int x = Integer.valueOf(initial[0]);
        int y = Integer.valueOf(initial[1]);

        int[][] data = new int[y][x];

        for(int i=0; i<y; i++) {
            int j = 0;
            for (char d : br.readLine().toCharArray()) {
                data[i][j++] = d - '0';
            }
        }

        new Main_1261_알고스팟().solution(data);
    }

    private void solution(int[][] data){
        Queue<Pair> queue = new LinkedList<Pair>();
        HashMap<String,Pair> hashMap = new HashMap<>();
        boolean[][] isVisit = new boolean[data.length][data[0].length];

        isVisit[0][0] = true;
        int degree = 0;

        queue.add(new Pair(0,0,0));

        while(queue.size()!=0){
            Pair pair = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (0 <= nx && nx < data[0].length && 0 <= ny && ny < data.length) {
                    if (isVisit[ny][nx] == false && data[ny][nx] == 0) {
                        isVisit[ny][nx] = true;
                        queue.add(new Pair(ny, nx, 0));
                    } else {
                        if (data[ny][nx] == 1) {
                            Pair isIn = hashMap.get(ny + "" + nx);
                            if (isIn == null) {
                                hashMap.put(ny + "" + nx, new Pair(ny, nx, degree));
                            }
                        }
                    }
                }
            }
            if(queue.size()==0){
                if(isVisit[data.length-1][data[0].length-1]==true){
                    System.out.println(degree);
                }else{
                    Iterator<String> it = hashMap.keySet().iterator();
                    while(it.hasNext()){
                        Pair p = hashMap.get(it.next());
                        data[p.y][p.x] = 0;
                        isVisit[p.y][p.x] = true;
                        queue.add(p);//못찾았으면 거기서 부터 다시 찾는다.
                    }
                    degree++;
                }
            }
        }

    }
}

class Pair{
    int y = 0;
    int x = 0;
    int degree = 0;

    public Pair(int y,int x,int degree) {
        this.y = y;
        this.x = x;
        this.degree = degree;
    }
}
