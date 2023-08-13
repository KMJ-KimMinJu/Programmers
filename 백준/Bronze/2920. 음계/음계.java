import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().strip().split(" ");

        String result = String.join("", str);

        if(result.equals("12345678")){
            System.out.println("ascending");
        }else if(result.equals("87654321")){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}