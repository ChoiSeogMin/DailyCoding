package random_question.problem_13460_째로탈출2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class problem_13460_째로탈출2_bestAnswer {

	static int N, M;
	static char[][] map;
	static boolean[][][][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new char[N][M];
		visit = new boolean[N][M][N][M];
		int rx=0, ry=0, bx=0, by=0;
		for(int i=0;i<N;i++) {
			String ss = br.readLine().trim();
			for(int j=0;j<M;j++) {
				map[i][j] = ss.charAt(j);
				if(map[i][j] == 'R') {
					rx = i; ry = j;
				} else if(map[i][j] == 'B') {
					bx = i; by = j;
				}
			}
		}
		Balls b = new Balls(rx,ry,bx,by);
		int cnt = bfs(b);
		System.out.println(cnt);
	}
	
	public static int bfs(Balls ball) {
		Queue<Balls> q = new LinkedList<Balls>();
		q.add(ball);
		visit[ball.r.x][ball.r.y][ball.b.x][ball.b.y]=true;
		int cnt=0;
		while(!q.isEmpty()) {
			int qs = q.size();
			while(qs--!=0) {
				Balls b = q.poll();
				int rx=b.r.x, ry=b.r.y, bx=b.b.x, by=b.b.y;
				if(map[rx][ry]=='O' && (rx!=bx || ry!=by)) {
					return cnt;
				}
				for(int i=0;i<4;i++) {
					int crx=rx, cry=ry,
						cbx=bx, cby=by;
					
					while(map[crx+dx[i]][cry+dy[i]] != '#' && map[crx][cry] != 'O') {
						crx += dx[i]; cry += dy[i];
					}
					while(map[cbx+dx[i]][cby+dy[i]] != '#' && map[cbx][cby] != 'O') {
						cbx += dx[i]; cby += dy[i];
					}
					if(crx==cbx && cry==cby) {
						if(map[crx][cry]=='O') {
							continue;
						} else {
							if(i==0 && ry < by) cry -= 1;
							else if(i==0 && ry>by) cby -= 1;
							if(i==1 && ry < by) cby += 1;
							else if(i==1 && ry > by) cry += 1;
							if(i==2 && rx < bx) crx -= 1;
							else if(i==2 && rx > bx) cbx -= 1;
							if(i==3 && rx < bx) cbx += 1;
							else if(i==3 && rx > bx) crx += 1;
						}
					}
					if(!visit[crx][cry][cbx][cby]) {
						visit[crx][cry][cbx][cby]=true;
						q.add(new Balls(crx,cry,cbx,cby));
					}
				}
			}
			if(cnt==10)
				break;
			cnt++;	
		}
		return -1;
	}
	
	public static class Balls {
		public Point r, b;
		public Balls(int rx, int ry, int bx, int by) {
			r = new Point(rx,ry);
			b = new Point(bx,by);
		}
	}

	public static class Point {
		public int x, y;
		public Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
}
