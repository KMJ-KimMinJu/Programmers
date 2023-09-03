import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String[] number = st.nextToken().split("-");

        int answer = 0;

        for(int i= 0; i<number.length; i++){

            int sum = 0;

            if(number[i].contains("+")){
                String[] plus = number[i].split("\\+");

                for(int k = 0; k<plus.length; k++){
                    sum += Integer.parseInt(plus[k]);
                }
            }else{
                sum = Integer.parseInt(number[i]);
            }

            if(i==0){ //첫 번째 값은 무조건 더하기
                answer = sum;
            }else{
                answer -= sum;
            }
        }

        System.out.println(answer);

    }
}