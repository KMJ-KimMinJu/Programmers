import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        ArrayList<String> category = new ArrayList<>();
        
        category.add("code");
        category.add("date");
        category.add("maximum");
        category.add("remain");
        
        int category_index = category.indexOf(ext);
        int sort_index = category.indexOf(sort_by);

        List<int[]> answer = new ArrayList<>();
        
        for(int[] arr : data){
            if(val_ext > arr[category_index]){
                answer.add(arr);
            }
        }
        
        answer.sort(Comparator.comparingInt(arr -> arr[sort_index]));
        return answer.toArray(new int[answer.size()][4]);

    }
}