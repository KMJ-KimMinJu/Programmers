import datetime as dt

now = input()
now=now.split(' ')
now = dt.datetime(2025,1,1,int(now[0]),int(now[1]))
time = int(input())
after=now+dt.timedelta(minutes=time)

print(after.hour,after.minute)