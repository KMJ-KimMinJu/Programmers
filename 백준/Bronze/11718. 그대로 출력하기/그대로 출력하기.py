b=[]
while True:
  try:
    a=input()
    if(a==' ' or a=='\n' or a==''):
      raise Exception
    b.append(a)
  except:
    break
for i in b:
  print(i)