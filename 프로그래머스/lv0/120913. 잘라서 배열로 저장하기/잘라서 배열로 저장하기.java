import java.util.ArrayList;
class Solution {
    public String[] solution(String my_str, int n) {
        /*
        String str = "";
        
        while(my_str.length()>0){
             
            if(my_str.length()>=n){
                str += my_str.substring(0, n) + " ";
                my_str = my_str.replace(my_str.substring(0, n), "");
                System.out.println(my_str);
                }
            else{
                str +=my_str.substring(0,my_str.length());
                my_str = my_str.replace(my_str.substring(0, my_str.length()), "");
                 System.out.println(my_str);
                }
        
        }
        
       System.out.println(str);
            return str.split(" "); */
        
    ArrayList<String> array = new ArrayList<>();
        
        for(int i= 0; i<my_str.length(); i+= n){
            
            if(my_str.length() - i >= n)
                array.add(my_str.substring(i, i+n));
            else if(my_str.length() - i < n){
                array.add(my_str.substring(i, my_str.length()));
            }
        }

        
        String[] s_arr = array.toArray(new String[array.size()]);
        
        return s_arr;
    }
}