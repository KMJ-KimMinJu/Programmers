function solution(a, b) {
    
    const dayOfWeek = ["SUN","MON","TUE","WED","THU","FRI","SAT"];
    
    const day = new Date(`2016-${a}-${b}`).getDay();
    
    return dayOfWeek[day];
}