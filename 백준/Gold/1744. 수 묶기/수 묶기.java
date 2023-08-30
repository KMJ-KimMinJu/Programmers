import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Integer> number = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken()); //횟수

        for(int i = 0;i<N; i++){
            st = new StringTokenizer(bf.readLine());
            number.offer(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> neg = new PriorityQueue<>(); //음수 저장해줄 큐
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder()); //양수 저장해줄 큐

        int zero = 0;

        while(number.size() != 0){
            if(number.peek()<0){
                neg.add(number.poll()); //음수 저장
            }else if(number.peek()>0){
                pos.add(number.poll()); //양수 저장
            }else{
                number.poll();
                zero ++;
            }
        }

        //일단은 양수끼리 곱해주고, 홀수개 남으면 더해주기
        //음수도 음수끼리 곱해주고, 남는 건 더하거나, 0이 있으면 곱해주기

        int result = 0; //결과

        //양수 처리

        while(pos.size() != 0){
            if(pos.size()>1){
                int n1 = pos.poll();
                int n2 = pos.poll();
                if(n1 == 1 || n2 == 1) {
                    result += (n1 + n2);

                }else{
                    result += (n1 * n2);
                }
            }else if(pos.size()==1){
                result += pos.poll();

                break;
            }
        }

        //음수 처리

        while(neg.size() != 0){
            if(neg.size()>1){
                result += (neg.poll()*neg.poll());

            }else if(neg.size()==1){
                if (zero < 1) {
                    result += neg.poll();
             
                }
                break;
            }
        }

        System.out.println(result);
    }
}