N=int(input())
a=[]
for i in range(N):
  b=input()
  a.append(b)
for i in a:
  if(len(i)>=2):
    print(i[0]+i[-1])
  else:
    print(i+i)