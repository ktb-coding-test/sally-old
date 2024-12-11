import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static BufferedWriter bw;
    static int[] currentSequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        currentSequence = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recursion(0, 0);

        bw.flush();
        bw.close();
    }

    static void recursion(int length, int start) throws IOException {
        if (length == m) {
            for (int i = 0; i < m; i++) {
                bw.write(currentSequence[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            currentSequence[length] = arr[i];
            recursion(length + 1, i + 1);
            visited[i] = false;
        }
    }
}
