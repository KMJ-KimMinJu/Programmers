import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 건물 종류

        int[] D = new int[N+1]; //진입 차수 배열
        int[] buildTime = new int[N+1]; //각 건축 시간 저장 배열

        ArrayList<Integer>[] node = new ArrayList[N+1]; //우선순위 확인용 배열

        for(int i = 1; i<= N; i++){
            node[i] = new ArrayList<>();
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());

            int time = Integer.parseInt(st.nextToken()); //건물 짓는데 걸리는 시간
            buildTime[i] = time; //건물 번호별로 짓는 시간 저장해주기

            //-1이 입력될 때까지 입력받음
            while(true){
                int number = Integer.parseInt(st.nextToken());

                if(number == -1){
                    break;
                }

                node[number].add(i); //우선순위가 되어야 하는 건물 연결
                D[i]++; //진입차수 배열
            }
        }

        List<Integer> indegree = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            if(D[i] == 0){ //진입차수가 0인 것부터 추가해주기
                indegree.add(i);
            }
        }

        int[] result = new int[N+1];

        while (indegree.size() != 0){
            int now = indegree.remove(0);

            for(int a : node[now]){
                D[a]--;
                result[a] = Math.max(result[a],result[now]+buildTime[now]); //우선시 되어야 하는 건물의 건축 시간을 더하기, 이전에 완료해야 하는 건물의 누적시간을 고려해야 하기 때문에 최댓값으로 갱신

                if(D[a] == 0){
                    indegree.add(a);
                }

            }
        }

        for(int i= 1; i<= N; i++){
            System.out.println(result[i]+buildTime[i]);
        }
    }

}