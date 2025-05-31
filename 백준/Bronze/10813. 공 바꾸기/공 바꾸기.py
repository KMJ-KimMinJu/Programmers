a=input().split(' ')
list_size=int(a[0])
N=int(a[1])
answer_list=list(range(1,list_size+1))
for i in range(N):
  order=input().split(' ')
  i, j = int(order[0]) - 1, int(order[1]) - 1  # 1-based → 0-based 인덱스 변환
  answer_list[i], answer_list[j] = answer_list[j], answer_list[i]  # 값 스왑
answer = ' '.join(map(str, answer_list))
print(answer)