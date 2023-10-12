import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int[] node; //모든 사람들의 대표노드

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집합의 수
        node = new int[N + 1];

        int M = Integer.parseInt(st.nextToken()); // 연산 개수

        //대표노드 설정
        for(int i = 0; i<= N; i++){
            node[i] = i;
        }

        //M만큼 연산 수행
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());

            int check = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(check == 0){ //0이라면 합집합 수행
                union(a,b);
            }else{ //1이라면 비교 수행
                if(find(a) == find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
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