a=input().split(' ')
list_size=int(a[0])
N=int(a[1])
list=['0']*list_size
for i in range(N):
  order=input().split(' ')
  for j in range(int(order[0])-1,int(order[1])):
    list[j]=order[2]
answer=' '.join(list)
print(answer)