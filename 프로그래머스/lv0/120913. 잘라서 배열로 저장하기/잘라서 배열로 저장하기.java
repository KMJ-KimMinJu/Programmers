import java.util.ArrayList;
class Solution {
    public String[] solution(String my_str, int n) {
        
        String str = "";

while(my_str.length() > 0){
    if(my_str.length() >= n){
        str += my_str.substring(0, n) + " ";
        my_str = my_str.substring(n);
    } else {
        str += my_str;
        my_str = "";
    }
}

return str.trim().split(" ");
   
//         String str = "";
//         while(my_str.length()>0){
             
//             //n개만큼 앞에서부터 자르고 자른 문자열은 삭제처리하는 방식
//             if(my_str.length()>=n){
//                 str += my_str.substring(0, n) + " ";
//                 my_str = my_str.replace(my_str.substring(0, n), "");
//                 System.out.println(my_str);
//                 }
//             else{ //마지막에 남은 개수가 n이 아닐 때 오류 해결 불가
//                 str +=my_str.substring(0,my_str.length());
//                 //my_str = my_str.replace(my_str.substring(0, my_str.length()), "");
//                 my_str="";
//                  System.out.println(my_str);
//                 }
//         }

//             return str.split(" "); 
        
    /*
    ArrayList<String> array = new ArrayList<>();
        
        for(int i= 0; i<my_str.length(); i+= n){
            
            //문자열의 길이와 인덱스를 빼주면서 n에 맞게 문자를 빼줌
            if(my_str.length() - i >= n)
                array.add(my_str.substring(i, i+n));
            else if(my_str.length() - i < n){ //n개로 빼줄 수 없을 때 싹 다 가져옴
                array.add(my_str.substring(i, my_str.length()));
            }
        }

        
        String[] s_arr = array.toArray(new String[array.size()]);
        
        return s_arr;*/
    }
}