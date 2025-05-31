from collections import Counter
a=input()
unarrageList=input()
unarrageList=unarrageList.split(' ')
findNumber=input()
arrangeDict=Counter(unarrageList)
print(arrangeDict[findNumber])