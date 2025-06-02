score=0
total_point=0
score_dict={'A+':4.5,'A0':4.0,'B+':3.5,'B0':3.0,'C+':2.5,'C0':2.0,'D+':1.5,'D0':1.0,'F':0}
while True:
  try:
    a=input().split(' ')
    if a=='' or a==' 'or a=='\n':
      raise Exception
    if(a[2]!='P'):
      score+=float(a[1])*score_dict[a[2]]
      total_point+=float(a[1])
  except:
    break

if score==0:
  print(0.00000)
else:
  print(score/total_point)