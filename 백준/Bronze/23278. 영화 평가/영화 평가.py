
N,L,H=input().split(' ')
N,L,H=int(N),int(L),int(H)
PointArray=sorted(list(map(int,input().split(' '))))
total=sum(PointArray[L:N-H:1])
print(total/(N-L-H))