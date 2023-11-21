import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] parent; //부모 노드 저장 배열
    static boolean[] visited;
    static int delete;
    static int answer;
    static ArrayList<Integer> tree[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];
        answer = 0;

        for(int i = 0; i<= N; i++){
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        int root = 0; //루트 노드의 번호 저장
        for(int i = 0; i<N; i++) {
            int s = Integer.parseInt(st.nextToken());

            if(s == -1){
                root = i;
            }else{
                tree[i].add(s);
                tree[s].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());

        delete = Integer.parseInt(st.nextToken());

        if(delete == root){
            //루트노드가 삭제노드라면 무조건 리프 노드는 0
            System.out.println(0);
        }else{
            DFS(root);
            System.out.println(answer);
        }

    }

    static void DFS(int number){
        visited[number] = true;

        boolean leaf = true; //자식노드의 개수
        for(int i : tree[number]){
            if(!visited[i] && delete != i){
                leaf = false;
                DFS(i);
            }
        }
        
        if(leaf){
            answer++; //자식 노드가 하나도 없을 때 리프노드값 증가
        }
    }
}