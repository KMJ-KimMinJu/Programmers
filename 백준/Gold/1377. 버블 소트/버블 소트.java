import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> sort_map = new HashMap<>(); //정렬 후 인덱스 저장
        HashMap<Integer, Integer> notsort_map = new HashMap<>(); //정렬 전 인덱스 저장

        int num = Integer.parseInt(st.nextToken());

        int[] sort = new int[num];

        for(int i=0; i<num; i++){
            sort[i] = Integer.parseInt(br.readLine());
            notsort_map.put(sort[i], i); //정렬 전 인덱스
        }

        Arrays.sort(sort); //정렬

        for(int i= 0; i<num; i++){
            sort_map.put(sort[i], i); //정렬 후 인덱스 저장
        }


        int result = 0;

        for(int i=0; i<num; i++){

            if((notsort_map.get(sort[i])- sort_map.get(sort[i]) > result)){
                result = notsort_map.get(sort[i]) - sort_map.get(sort[i]);
            }
        }

        System.out.println(result+1);

    }
}