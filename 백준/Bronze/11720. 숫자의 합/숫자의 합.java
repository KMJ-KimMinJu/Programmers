import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        String[] array = sc.next().split("");

        long sum = 0;

        for (int i = 0; i < count; i++) {
            sum += Long.parseLong(array[i]);
        }

        System.out.println(sum);
    }

}
