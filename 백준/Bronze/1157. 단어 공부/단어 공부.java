import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String str = st.nextToken();

        if(str.length() > 1000000){
            str = str.substring(1000000);
        } else {
            str = str.substring(0, Math.min(1000000, str.length()));
        }

        str = str.toLowerCase();
        String[] N = str.split(""); //알파벳

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<N.length; i++){
            if (map.containsKey(N[i])) {
                    map.put(N[i], map.get(N[i]) + 1);
            } else {
                map.put(N[i], 1);
            }
        }

        int max = 0;
        String result = "";

        Set<String> keySet = map.keySet();

        for(String key: keySet){

           if(max < (int) map.get(key)){
               max = map.get(key);
               result = key;
           }else if(max == (map.get(key))){
               result = "";
           }
        }

        if(result.length() != 0){
            System.out.println(result.toUpperCase());
        }else{
            System.out.println("?");
        }
    }
}