import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		String[] str = new String[t];
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			str[i] = st.nextToken();
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<t; i++) {
			int p1=0, p2=str[i].length()-1, result=0;
			while(p1<p2) {
				if(str[i].charAt(p1)==str[i].charAt(p2)) {
					p1++; p2--;
				}
				else {
					if(isPalindrome(str[i], p1 + 1, p2) || isPalindrome(str[i], p1, p2 - 1)) {
                        result = 1;
                    } else {
                        result = 2;
                    }
					break;
				}
		}
			sb.append(result + "\n");
	}
	System.out.println(sb);
		

	}
	private static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

