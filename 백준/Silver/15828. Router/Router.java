import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		while(true) {
			int checkVal = Integer.parseInt(br.readLine());
			if(checkVal == -1) break;			
			if(checkVal == 0) queue.poll();
			else if(queue.size() < n) queue.offer(checkVal);
		}
		if(queue.isEmpty()) {
			sb.append("empty");
		}
		else
			for(int val : queue) {
				sb.append(val+" ");
			}
		System.out.println(sb);
		}
	
	}