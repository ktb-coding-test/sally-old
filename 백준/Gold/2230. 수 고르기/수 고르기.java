import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int p1=0, p2=0, result=A[N-1]-A[0];
		while(p1<=p2 && p2 < N) {
			if(A[p2]-A[p1] >= M) {
				result = Math.min(result, A[p2]-A[p1]);
				p1++;
			}
			else 
				p2++;
		}
		System.out.println(result);
	}
}
