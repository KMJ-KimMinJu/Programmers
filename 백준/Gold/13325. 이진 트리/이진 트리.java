import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N, answer = 0; //깊이, 가중치의 합
    static int[] tree;
    public static void main(String[] args) throws IOException {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2,N+1)-1;

        tree = new int[length+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 2; i <= length; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        search(1, 0);
        System.out.println(answer);
    }

    /*포화 이진트리라서 모든 노드에 자식이 2개씩 있음*/
    //왼쪽, 오른쪽, 루트
    static int search(int start, int depth){

        if(depth == N) { // 최대 깊이에 도달
            answer += tree[start];
            return tree[start];
        }

        //왼쪽
        int left = search(start*2,depth+1);

        //오른쪽
       int right = search(start*2+1,  depth+1);

        answer += tree[start] + Math.abs(left-right); //Math.abs(left-right) --> 원래의 가중치에 더 큰 가중치 값을 위해 필요한 만큼 더 더해주기

        return tree[start] + Math.max(left, right); //가중치를 큰값으로 기준을 두고 해주기
    }
}