import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


        class Position implements Comparable<Position> {
            int x;
            int y;
            int cnt;

            public Position(int x, int y, int cnt) {
                super();
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }

            @Override
            public int compareTo(Position o) {
                return cnt-o.cnt;
    }


}

public class Main_1261_Answer {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        int[][] ar = new int[n][m];
        String str = null;
        for (int i = 0; i < n; ++i) {
            str = br.readLine().trim();
            for (int j = 0; j < m; ++j) {
                ar[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<Position> pq = new PriorityQueue<>();

        pq.add(new Position(0, 0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        Position pos = null;
        int x, y, cnt;

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            pos = pq.poll();
            x = pos.x;
            y = pos.y;
            cnt = pos.cnt;

            if (x == n - 1 && y == m - 1) {
                System.out.println(cnt);
                return;
            }

            // 4방향
            for (int i = 0; i < 4; ++i) {
                if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < m
                        && !visited[x + dx[i]][y + dy[i]]) {
                    if (ar[x + dx[i]][y + dy[i]] == 0) {
                        pq.add(new Position(x + dx[i], y + dy[i], cnt));
                    } else {
                        pq.add(new Position(x + dx[i], y + dy[i], cnt + 1));
                    }
                    visited[x + dx[i]][y + dy[i]] = true;
                }
            }

        }
    }
}
