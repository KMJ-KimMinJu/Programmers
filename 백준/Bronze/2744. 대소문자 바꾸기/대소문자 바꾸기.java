import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String str = st.nextToken();
        String answer = "";

        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);

            //대문자
            if(temp >= 65 && temp <= 90){
                temp += 32;
                answer += String.valueOf(temp);
            }else{
                temp -= 32;
                answer += String.valueOf(temp);
            }
        }

        System.out.println(answer);
    }

}