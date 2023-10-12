import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수

        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        int[] D = new int[N+1]; //진입차수 저장 배열

        ArrayList<Integer>[] node = new ArrayList[N+1];

        for(int i = 1; i<= N; i++){
            node[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].add(b);

            D[b]++;
        }

        List<Integer> indegree = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            if(D[i] == 0){
                indegree.add(i);
            }
        }

        while (indegree.size() != 0){
            int now = indegree.remove(0);

            System.out.print(now+" ");

            for(int a : node[now]){
                D[a]--;
                if(D[a] == 0){
                    indegree.add(a);
                }

            }
        }

    }
    
}