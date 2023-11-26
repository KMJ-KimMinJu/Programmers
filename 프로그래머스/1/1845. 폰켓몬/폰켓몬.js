function solution(nums) {
    
    const origin_length = nums.length;
    
    nums = nums.filter((element, index) => {
        return nums.indexOf(element) === index;
    });
    
    const change_length = nums.length;
    
    if(change_length > parseInt(origin_length/2)){
        return parseInt(origin_length/2);
    }else{
        return change_length;
    }
}