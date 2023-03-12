import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    ArrayList<Integer> ar = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public void solution(String str)
    {
        StringTokenizer st = new StringTokenizer(str);
        String order = st.nextToken();

        switch(order)
        {
            // 정수 X를 덱의 앞에 넣는다.
            case "push_front":
                int tmp = Integer.parseInt(st.nextToken());
                ar.add(0, tmp);
                break;

            // 정수 X를 덱의 뒤에 넣는다.
            case "push_back":
                int tmp2 = Integer.parseInt(st.nextToken());
                ar.add(tmp2);
                break;

            // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력. 없으면 -1 출력
            case "pop_front":
                if (ar.isEmpty())
                    // 값이존재하지 않을 때
                    sb.append(-1 + "\n");
                else {
                    sb.append(ar.remove(0) + "\n");
                }
                break;

            // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력. 없으면 -1 출력
            case "pop_back":
                if(ar.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(ar.remove(ar.size()-1) + "\n");
                break;

            //덱에 들어있는 정수의 개수를 출력
            case "size":
                sb.append(ar.size() + "\n");
                break;

            // 덱이 비어있으면 1, 아니면 0을 출력
            case "empty":
                if(ar.isEmpty())
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
                break;

            // 덱의 가장 앞의 정수를 출력. 없는 경우에는 -1 출력
            case "front":
                if (ar.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(ar.get(0) + "\n");
                break;

            // 덱의 가장 뒤의 정수를 출력. 없는 경우에는 -1 출력
            case "back":
                if (ar.isEmpty())
                    sb.append(-1 + "\n");
                else
                    sb.append(ar.get(ar.size()-1) + "\n");
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++)
        {
            String str = br.readLine();
            T.solution(str);
        }
        System.out.println(sb.toString());
    }
}