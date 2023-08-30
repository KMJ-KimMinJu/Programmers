import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전 종류

        //낮은 숫자가 우선순위
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            priorityQueueLowest.add(Integer.valueOf(st.nextToken()));
        }

        int sum = 0;

        while(priorityQueueLowest.size() != 1){

            int plus = priorityQueueLowest.poll() + priorityQueueLowest.poll();
            sum += plus;

            priorityQueueLowest.offer(plus);
        }

        System.out.println(sum);
    }
}