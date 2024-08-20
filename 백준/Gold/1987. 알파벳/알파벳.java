import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static int[][] arr;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부를 체크
    static int max = 0;

    // 상하좌우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j) - 'A'; // 'A'를 빼서 0부터 25까지의 숫자로 변환
            }
        }

        dfs(0, 0, 1);

        bw.write(max + "\n"); // BufferedWriter를 사용해 결과 출력
        bw.flush(); 
        bw.close(); 
    }

    static void dfs(int x, int y, int count) {
        visited[arr[x][y]] = true; // 현재 위치의 알파벳을 방문 처리
        max = Math.max(max, count); // 최대 이동 칸 수 갱신

        // 상하좌우로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[arr[nx][ny]]) {
                dfs(nx, ny, count + 1);
            }
        }

        visited[arr[x][y]] = false; // 백트래킹: 다른 경로를 탐색하기 위해 방문을 해제
    }
}
