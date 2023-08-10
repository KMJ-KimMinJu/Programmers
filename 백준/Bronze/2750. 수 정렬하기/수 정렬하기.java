
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        int[] sort = new int[num];

        for(int i= 0; i<num; i++){
            sort[i] = Integer.parseInt(br.readLine());
        }

        for(int i= 1; i<num; i++){
            for(int j = i; j>0; j--){
                if(sort[j]<sort[j-1]){
                    int temp = sort[j];
                    sort[j] = sort[j-1];
                    sort[j-1] = temp;
                }
            }
        }

        for(int i=0; i<num; i++){
            System.out.println(sort[i]);
        }
    }
}