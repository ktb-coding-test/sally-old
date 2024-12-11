import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[] visit;
	static int[] arr;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[m];
		
		recursion(0, 0);
		bw.flush();
		bw.close();

	}
	static void recursion(int at, int depth) throws IOException {
		if(depth == m) {
			for(int val : arr) {
				bw.append(val + " ");
			}
			bw.append("\n");
			return;
		}
		for(int i = at; i < n; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				arr[depth] = i+1;
				recursion(i+1, depth+1);
				visit[i] = false;
			}

		}
	}
}
