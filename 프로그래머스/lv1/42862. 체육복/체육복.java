// import java.util.Arrays;
// class Solution {
//     public int solution(int n, int[] lost, int[] reserve) {
//         int answer = 0;
        
//         int[] std = new int[n];
        
//         Integer[] re = new Integer[reserve.length];
//         Integer[] lo = new Integer[lost.length];
        
//         Arrays.sort(lost);
//         Arrays.sort(reserve);
        
//         for(int i = 0; i<reserve.length; i++){
//             re[i] = Integer.valueOf(reserve[i]);
//         }
        
        
//         for(int i = 0; i<lost.length; i++){
//             lo[i] = Integer.valueOf(lost[i]);
//         }
        
//         for(int i = 0; i<std.length; i++){
//             std[i] = 0;
//         }
        
//         for(int i =0; i<re.length; i++){
//             std[reserve[i]-1] = 1; //여분으로 들고온 건 1
//         }

//         for(int i = 0; i<lo.length; i++){
//             System.out.print(Arrays.asList(re).indexOf(lost[i]) + " ");
//             if(Arrays.asList(reserve).indexOf(lo[i]) == -1){
//                 std[lost[i]-1] = 2; //도난학생 2
//             }
//             else{
//                 std[lost[i]-1] = 0;
//             }
        
//         }
        
//         for(int i = 0; i<std.length; i++){
//             System.out.println(std[i]);
//         }
        
        
//         if(std[0] == 2){
//             if(std[1] == 1){
//                 std[0] = 0;
//                 std[1] = 0;
//             }
//         }
    
//         for(int i = 1; i<std.length-1; i++){
//             int count = 0;
//             if(std[i]==2){
                
//                 if(std[i-1] == 1) 
//                     count ++;
//                 if(std[i+1] == 1)
//                     count ++;
                
//                 if(count == 2){
//                     std[i] = 0;
//                     std[i-1] = 0;
//                 }else if(count == 1){
//                     if(std[i-1] == 1) {
//                         std[i] = 0;
//                         std[i-1] = 0;
//                     }else if(std[i+1] == 1){
//                         std[i] = 0;
//                         std[i+1] = 0;
//                     }
//                 }
//             }
//         }
            
//         if(std[std.length-1] == 2){
//             if(std[std.length-2] == 1)
//                 std[std.length-1] = 0;
//         }
        
//         for(int i=0; i<std.length; i++){
//             if(std[i]==2)
//                 continue;
//             else
//                 answer += 1;
//         }
        
//         return answer;
//     }
// }

import java.util.Arrays;

class Solution{
     public int solution(int n, int[] lost, int[] reserve){
         int[] std = new int[n+2];
         int answer = 0;
         
         Arrays.sort(lost);
         Arrays.sort(reserve);
         
         for(int i : lost)
             std[i] --;
         
         for(int i : reserve)
             std[i] ++;
         
         
         for(int i = 1; i<n+1; i++){
             if(std[i] == -1){
                 if(std[i-1] == 1){
                     std[i-1] --;
                     std[i] ++;
                 }else if(std[i+1] == 1){
                     std[i+1] --;
                     std[i] ++;
                 }
             }
             
             
             if(std[i] != -1){
                 answer ++;
             }
         
         }
         
         // for(int i = 0; i<std.length; i++){
         //     if(std[i] != -1){
         //         answer ++;
         //     }
         // }
         
         return answer;
         
         
     }
}