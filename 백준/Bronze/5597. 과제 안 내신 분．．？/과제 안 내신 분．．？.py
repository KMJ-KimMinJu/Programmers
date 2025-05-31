answer_list=list(range(1,30+1))
for i in range(28):
  order=input()
  j = int(order)
  answer_list[j-1]=0
answer=filter(lambda x : x != 0 ,answer_list)
for i in answer:
  print(i)