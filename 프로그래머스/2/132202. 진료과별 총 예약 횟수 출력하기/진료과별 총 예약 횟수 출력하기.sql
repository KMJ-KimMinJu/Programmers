-- 코드를 입력하세요
SELECT MCDP_CD 진료과코드, COUNT(APNT_NO) 5월예약건수
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y%m')='202205' 
GROUP BY MCDP_CD
ORDER BY COUNT(APNT_NO), MCDP_CD;