class Stack {
  constructor() {
    this._arr = [];
  }
  push(item) {
    this._arr.push(item);
  }
  pop() {
    return this._arr.pop();
  }
  peek() {
    return this._arr[this._arr.length - 1];
  }
length(){
        return this._arr.length;
    }
}

function solution(arr)
{
    
    const stack = new Stack();
    stack.push(arr[0]);
    
    for(let i = 1; i<arr.length; i++){
        if(stack.peek() == arr[i]){
            continue;
        }else{
            stack.push(arr[i]);
        }
    }
    
    let answer = [];
    const index= stack.length();
    for(let i = 0; i<index; i++){
        answer.push(stack.pop());
    }
    
    return answer.reverse();
}