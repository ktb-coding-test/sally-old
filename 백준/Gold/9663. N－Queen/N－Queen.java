import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] arr;
	static int count;
	
	public static void main(String[] args) throws IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 StringTokenizer st = new StringTokenizer(br.readLine());
	 
	 n = Integer.parseInt(st.nextToken());
	 arr = new int[n];
	 count = 0;
	 
	 recursion(0);
	 bw.flush();
	 bw.write(String.valueOf(count));
	 bw.close();
	 

	}
	static void recursion(int depth) {
		if(depth == n) { 
			count++;
			return;
		}
		for(int i = 0; i<n; i++) {
			arr[depth] = i;  //	배열의 index가 행, 값이 열을 나타냄.
			if(possible(depth)) //놓일 수 있는 자리라면 다음 행으로 가 재귀.
				recursion(depth+1);
		}
	}
	static boolean possible(int row) {
		for(int i =0; i<row; i++) {
			if(arr[i]==arr[row]) //같은 열에 퀸이 있는지 확인.
				return false;
			else if(Math.abs(row-i) == Math.abs(arr[row]-arr[i])) //행과 열 차이가 같으면 같은 대각선.
				return false;
		}
		return true;
	}
}
