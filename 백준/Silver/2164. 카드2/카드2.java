import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        boolean check = false; //false는 버리기 true는 제일 아래로 옮기기

        //큐에 카드 번호 추가
        for(int i = 1; i<=num; i++){
            queue.add(i);
        }

        while(queue.size() != 1){

            if(check==false){
                queue.poll();
                check=true;
            }else if(check == true){
                int change = queue.poll();
                queue.add(change);
                check = false;
            }
        }

        System.out.println(queue.peek());
    }
}