import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int[] node; //모든 사람들의 대표노드

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 수
        node = new int[N + 1];

        st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken()); // 여행 계획에 속한 도시의 수

        //대표노드 설정
        for(int i = 0; i<= N; i++){
            node[i] = i;
        }

        //N만큼 연산 수행
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());

            for(int j = 1; j<=N; j++){
                if(Integer.parseInt(st.nextToken())==1){
                    union(i+1, j);
                }
            }
        }

        st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        boolean check = true;

        for(int i = 1; i<M; i++){
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)){
                check = false;
            }
        }

        if(check){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    //한 개의 집합으로 묶기
    public static void union(int a, int b){

        //두 노드가 같은 집합에 속해 있는지 확인
        a = find(a);
        b = find(b);

        //두 노드가 같은 집합이 아니라면 한 개의 집합으로 만들어주기 위해 대표 노드 변경
        if(a != b){
            node[b] = a;
        }
    }

    public static int find(int a){
        if(a == node[a]){
            return a;
        }else{
            node[a] = find(node[a]); //node[a]값이 가리키는 index 위치로 가서 확인
            return node[a];
        }
    }
}