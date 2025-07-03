x=int(input())
answer=0
y=[64,32,16,8,4,2,1]
for i in y:
    if x >= i:
        x-=i
        answer+=1
print(answer)