import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] sort;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //데이터 개수
        int K = Integer.parseInt(st.nextToken()); //구해야 하는 자리

        sort = new int[N];

        st = new StringTokenizer(bf.readLine());
        //데이터 받아오기
        for (int i = 0; i < N; i++) {
            sort[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);

        System.out.println(sort[K - 1]);
    }

    public static void quickSort(int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;
            int pivot = sort[mid]; //중간 지점을 피벗으로 설정
            int divide = partition(left, right, pivot);

            quickSort(left, divide-1);
            quickSort(divide , right);
        }
    }

    public static int partition(int left, int right, int pivot) {
        while (left <= right) {
            while (sort[left] < pivot) {
                left++;
            }
            while (sort[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = sort[left];
                sort[left] = sort[right];
                sort[right] = temp;
                left++;
                right--;
            }
        }

                if(left==right){
            if(sort[left] < pivot){
                return right;
            }else{
                return left;
            }

        }

        return left;
    }
}