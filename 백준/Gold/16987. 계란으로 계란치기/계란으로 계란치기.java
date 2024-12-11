import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] dura;
	static int[] weight;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		
		dura = new int[n];
		weight = new int[n];
		for(int i =0; i< n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dura[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		recursion(0, 0);
		System.out.println(cnt);
	}
	static void recursion(int idx, int count) {
			if(idx == n) {
				cnt = Math.max(cnt,count);
				return;
			}
			if(dura[idx]<=0 || count==n-1) {
				recursion(idx+1, count);
				return;			
			}
			for(int i =0; i<n; i++) {
				if(i==idx) continue;
				if(dura[i]>0) {
					dura[idx] -= weight[i];
					dura[i] -= weight[idx];
					
					int newCount = count;
	                if (dura[idx] <= 0) newCount++;
	                if (dura[i] <= 0) newCount++;  
	                
					recursion(idx+1, newCount);
					
					dura[idx] += weight[i];
					dura[i] += weight[idx];
				}
			}
		}
	}
