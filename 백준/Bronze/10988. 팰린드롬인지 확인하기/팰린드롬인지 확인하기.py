a=input()
a_length=len(a)
if a_length==1:
  print(1)
else:
  left=a[0:a_length//2]
  right=a[a_length-1:a_length-a_length//2-1:-1]
  if left==right:
    print(1)
  else:
    print(0)
