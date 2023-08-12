import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1>o2?1:-1; //절댓값이 같을 경우 음수 먼저
                }else{
                    return Math.abs(o1) - Math.abs(o2); //절댓값이 작은 기준으로 정렬
                }
            }
        });

        for(int i=0; i<num; i++){

            int sc = Integer.parseInt(br.readLine());

            if(sc == 0){
                if(priorityQueue.size() == 0) {
                    System.out.println(0);
                }else{
                    System.out.println(priorityQueue.poll());
                }
            }else {
                priorityQueue.add(sc);
            }
        }
    }
}