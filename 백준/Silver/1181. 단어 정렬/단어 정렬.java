import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        HashSet<String> dic = new HashSet<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            dic.add(st.nextToken());
        }

        ArrayList<String> dic_list = new ArrayList<>(dic);

        Collections.sort(dic_list, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() > b.length()) return 1;
                else if(a.length() == b.length()){
                    return a.compareTo(b);
                }else {
                    return -1;
                }
            }
        });

        for(String str : dic_list){
            System.out.println(str);
        }
    }

}