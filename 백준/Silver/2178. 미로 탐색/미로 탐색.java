import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[n][m];
		for(int i =0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs(maze, n, m));
	}
	static int bfs(int[][] maze, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		
		int[][] distance = new int[n][m];
		distance[0][0] = 1;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			
			for(int i =0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m) {
					continue;
				}
				if (maze[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
				visited[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new int[] {nx, ny});
			}
		}
		return distance[n-1][m-1];
	}
}
