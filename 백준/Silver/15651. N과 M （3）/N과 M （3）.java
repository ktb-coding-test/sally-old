import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static int[] visit;
	static StringBuilder sb;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		recursion(0);
		System.out.println(sb);
	}
	static void recursion(int depth) {
		if(depth==m) {
			for(int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < n; i++) {
			arr[depth] = i+1;
			recursion(depth+1);
		}
	}
}
