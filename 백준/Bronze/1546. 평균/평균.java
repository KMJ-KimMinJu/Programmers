import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        String[] array = sc.nextLine().split(" ");

        float sum = 0;
        int max_num = 0;

        for(int i = 0; i<array.length; i++){
            max_num = Math.max(max_num, Integer.parseInt(array[i]));
        }

        for(int i = 0; i<array.length; i++){
                float score = Float.parseFloat(array[i])/max_num*100;
                sum += score;
        }

        System.out.println(sum/count);
    }
}