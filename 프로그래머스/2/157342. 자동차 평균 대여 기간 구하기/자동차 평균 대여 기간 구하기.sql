-- 코드를 입력하세요
# SELECT CAR_ID, ROUND(AVG(DAY), 1) AS AVERAGE_DURATION FROM 
# (SELECT CAR_ID, DATEDIFF(END_DATE, START_DATE) AS DAY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# ) A
# GROUP BY CAR_ID
# HAVING AVG(DAY) >= 7
# ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;

SELECT  CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1),1) AS AVERAGE_DURATION 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;