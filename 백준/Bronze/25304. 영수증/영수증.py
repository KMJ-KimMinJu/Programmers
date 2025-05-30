total = input()
sum=0
N=input()
for i in range(int(N)):
  pro=input().split(' ')
  sum+=int(pro[0])*int(pro[1])
if(sum==int(total)):
  print('Yes')
else:
  print('No')