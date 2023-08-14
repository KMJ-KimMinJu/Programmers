import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().strip().split("");

        for(int i=0; i<str.length; i++){

            int max = 0;
            int index = i;

            for(int j=i+1; j<str.length; j++){

                if(max < Integer.parseInt(str[j])){
                    max = Integer.parseInt(str[j]);
                    index = j;
                }
            }

            if(Integer.parseInt(str[i])<Integer.parseInt(str[index])){
                String temp = str[i];
                str[i] = str[index];
                str[index] = temp;
            }
        }

        for(String a:str){
            System.out.print(a);
        }
    }
}