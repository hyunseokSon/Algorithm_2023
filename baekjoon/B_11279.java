import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();
    public void solution(int a)
    {
        if (a==0)
        {
            if (pq.isEmpty())
                sb.append(0 + "\n");
            else
                sb.append(pq.poll() + "\n");
        }
        else
            pq.add(a);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++)
        {
            int a = Integer.parseInt(br.readLine());
            T.solution(a);
        }
        System.out.println(sb.toString());
    }
}