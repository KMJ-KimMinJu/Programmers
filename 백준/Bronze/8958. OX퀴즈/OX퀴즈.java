import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //데이터 개수

        int sum = 0;
        int count = 0;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            String[] ox = st.nextToken().split("");

            for(int j = 0; j<ox.length; j++){

                if(ox[j].equals("O")){
                    count ++;
                }else{
                    count = 0;
                }
                sum += count;
            }

            System.out.println(sum);
            sum = 0;
            count = 0;
        }
    }
}