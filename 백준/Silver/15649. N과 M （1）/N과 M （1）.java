import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] visit;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[m];
		recursion(n, m, 0);
		bw.flush();
		bw.close();

	}

	static void recursion(int n, int m, int depth) throws IOException {
		if (depth == m) {
			for (int val : arr) {
				bw.write(val + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				arr[depth] = i + 1;
				recursion(n, m, depth + 1);
				visit[i] = false;
			}

		}
	}
}
