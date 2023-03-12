import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int cnt;

    // 노드 삭제 시 하위 노드 및 하위 리프 노드를 재귀를 통해 모두 삭제.
    public void Delete(int d, int n, int[] arr)
    {
        arr[d] = -2;
        for(int i=0; i<n; i++) {
            if(arr[i] == d)
            {
                Delete(i, n, arr);
            }
        }
    }

    public void countLeaf(int s, boolean[] visited, int[] arr, int n)
    {
        boolean leaf = true;
        visited[s] = true;
        if(arr[s] != -2)
        {
            for (int i=0; i<n; i++)
            {
                if(arr[i] == s && visited[i] == false)
                {
                    countLeaf(i,visited,arr,n);
                    leaf = false;
                }
            }
            if (leaf)
                cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;

        for(int i=0; i<n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == -1)
                root = i;
        }

        // 삭제하고픈 노드
        int delete = Integer.parseInt(br.readLine());
        T.Delete(delete, n, arr);

        boolean[] visited = new boolean[n];
        // 총 리프노드의 개수를 위한 변수
        cnt = 0;
        T.countLeaf(root, visited, arr, n);
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}