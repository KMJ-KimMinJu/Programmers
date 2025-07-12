import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static Queue<Integer[]> qu;
    public static PriorityQueue<Integer> pq;

    /*
    *
    * 우선순위 큐와 일반 큐를 만들어서 체크
    * 우선순위 큐에는 중요도 순으로 정렬된 큐가 들어감
    * 일반 큐에는 들어산 순서와 중요도가 담긴 배열이 들어감
    *
    * 일반 큐와 우선순위 큐를 비교하면서 중요도 순으로 일반 큐에서 숫자를 문서를 뺌!
    * 내가 찾는 문서의 인덱스가 빠져나가면 로직 종료
    *
    * */
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());

            int paper = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());

            if(paper == 1){
                System.out.println(1);
                continue;
            }

            pq = new PriorityQueue<>(Comparator.reverseOrder());
            qu = new LinkedList<>();
            
            for(int j = 0; j < paper; j++){
                int number = Integer.parseInt(st.nextToken());
                qu.offer(new Integer[]{number, j});
                pq.offer(number);
            }

            testQueue(check);
        }
    }

    public static void testQueue(int check){

        int count = 0;

        while(!qu.isEmpty()) {

            int temp = pq.peek(); //제일 큰 값
            Integer[] com_temp = qu.poll();

            if (temp == com_temp[0]) {
                count++;
                pq.poll();

                if (com_temp[1] == check) {
                    break;
                }
            } else {
                qu.offer(com_temp);
            }
        }

        System.out.println(count);
    }
}