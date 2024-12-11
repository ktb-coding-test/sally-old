import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static int[][] graph;
    static int[] dist; // 최소 비용 저장
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 수 n과 버스의 수 m을 입력받음
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());  // 도시 수
        m = Integer.parseInt(br.readLine());  // 버스 수

        // 배열 초기화
        graph = new int[n + 1][n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 같은 경로에서 더 작은 비용이 있을 경우 갱신
            graph[start][end] = Math.min(graph[start][end], cost);
        }

        // 시작 도시와 도착 도시 입력
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘을 실행해 최소 비용 계산
        dijkstra(startCity);

        // 결과 출력: 도착 도시까지의 최소 비용
        System.out.println(dist[endCity]);
    }

    // 다익스트라 알고리즘 구현
    static void dijkstra(int start) {
        Arrays.fill(dist, INF);  // 거리를 모두 무한대로 초기화
        dist[start] = 0;  // 시작 도시의 거리는 0

        for (int i = 0; i < n; i++) {
            int u = getSmallestNode();  // 방문하지 않은 노드 중 가장 작은 거리의 노드 선택
            if (u == -1) break;  // 더 이상 선택할 노드가 없을 때 루프 종료
            visited[u] = true;  // 해당 노드를 방문 처리

            // 선택된 노드와 연결된 노드들의 경로 탐색
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && graph[u][v] != INF) {
                    if (dist[v] > dist[u] + graph[u][v]) {
                        dist[v] = dist[u] + graph[u][v];  // 더 짧은 경로가 있으면 업데이트
                    }
                }
            }
        }
    }

    // 방문하지 않은 노드 중 가장 작은 거리를 가진 노드 선택
    static int getSmallestNode() {
        int minValue = INF;
        int index = -1;  // 초기화
        for (int i = 1; i <= n; i++) {  // 1부터 n까지 반복
            if (!visited[i] && dist[i] < minValue) {
                minValue = dist[i];
                index = i;
            }
        }
        return index;
    }
}
