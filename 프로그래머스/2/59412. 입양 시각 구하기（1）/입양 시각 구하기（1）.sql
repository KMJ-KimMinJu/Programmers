-- 코드를 입력하세요
SELECT HOUR(DATETIME) HOUR, COUNT(DATETIME) FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR >= 9 && HOUR < 20
ORDER BY HOUR;