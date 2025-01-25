-- 코드를 작성해주세요

SELECT YEAR(B.DIFFERENTIATION_DATE) YEAR, (A.YEAR_MAX - B.SIZE_OF_COLONY) YEAR_DEV ,B.ID FROM ECOLI_DATA B
JOIN (SELECT YEAR(DIFFERENTIATION_DATE) YEAR, MAX(SIZE_OF_COLONY) YEAR_MAX FROM ECOLI_DATA
GROUP BY YEAR
ORDER BY YEAR, YEAR_MAX) A 
ON A.YEAR = YEAR(B.DIFFERENTIATION_DATE)
ORDER BY YEAR, YEAR_DEV