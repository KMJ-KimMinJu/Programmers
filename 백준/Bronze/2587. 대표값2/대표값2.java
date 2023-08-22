import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] sort = new int[5];

        for(int i= 0; i<5; i++){
            sort[i]=Integer.parseInt(bf.readLine());
        }

        Arrays.sort(sort);

        System.out.println(Arrays.stream(sort).sum()/5);
        System.out.println(sort[sort.length/2]);
    }
}