import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Back11728 {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	int max=0, min=0;
	
	st = new StringTokenizer(br.readLine());
	int[] A = new int[N];
	for(int i = 0; i < N; i++) {
		A[i]=Integer.parseInt(st.nextToken());
	}
	
	st = new StringTokenizer(br.readLine());
	int[] B = new int[M];
	for(int i = 0; i < M; i++) {
		B[i] = Integer.parseInt(st.nextToken());
	}
	
	int[] arr = new int[N+M];
	StringBuilder sb = new StringBuilder();
    int p1 = 0, p2 = 0, j = 0;

    while(p1 < N && p2 < M) {
        if(A[p1] <= B[p2]) 
            sb.append(A[p1++]).append(" ");
        else
            sb.append(B[p2++]).append(" ");
    }

    while(p1 < N) {
        sb.append(A[p1++]).append(" ");
    }

    while(p2 < M) {
        sb.append(B[p2++]).append(" ");
    }

    System.out.println(sb);
	}
}
	



