import java.util.*;
import java.io.*;

public class Main {
	    static ArrayList<Integer>[] graph;
	    static boolean[] visited;

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int N = Integer.parseInt(st.nextToken()); 
	        int M = Integer.parseInt(st.nextToken()); 
	        int V = Integer.parseInt(st.nextToken()); 

	        graph = new ArrayList[N + 1];
	        for (int i = 1; i <= N; i++) {
	            graph[i] = new ArrayList<>();
	        }

	        for (int i = 0; i < M; i++) {
	            st = new StringTokenizer(br.readLine());
	            int u = Integer.parseInt(st.nextToken());
	            int v = Integer.parseInt(st.nextToken());
	            graph[u].add(v);
	            graph[v].add(u);
	        }

	        // 인접 리스트의 정점들을 오름차순으로 정렬
	        for (int i = 1; i <= N; i++) {
	            Collections.sort(graph[i]);
	        }

	        visited = new boolean[N + 1];
	        dfs(V);
	        System.out.println();

	        visited = new boolean[N + 1];
	        bfs(V);
	        System.out.println();
	    }

	    static void dfs(int v) {
	        visited[v] = true;
	        System.out.print(v + " ");
	        for (int next : graph[v]) {
	            if (!visited[next]) {
	                dfs(next);
	            }
	        }
	    }

	    static void bfs(int start) {
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(start);
	        visited[start] = true;

	        while (!queue.isEmpty()) {
	            int v = queue.poll();
	            System.out.print(v + " ");

	            for (int next : graph[v]) {
	                if (!visited[next]) {
	                    queue.offer(next);
	                    visited[next] = true;
	                }
	            }
	        }
	    }
	}
