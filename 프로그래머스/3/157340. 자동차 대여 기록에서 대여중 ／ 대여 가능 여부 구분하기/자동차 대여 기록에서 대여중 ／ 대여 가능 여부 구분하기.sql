-- 코드를 입력하세요
SELECT CAR_ID,
(CASE WHEN '2022-10-16' BETWEEN MAX(START_DATE) AND MAX(END_DATE) THEN '대여중'
ELSE '대여 가능'
END) AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE <= '2022-10-16'
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;
