-- 코드를 입력하세요
SELECT BOOK_ID, substr(PUBLISHED_DATE, 1, 10) as PUBLISHED_DATE FROM BOOK WHERE CATEGORY = "인문" AND substr(PUBLISHED_DATE, 1, 4) = 2021 
                                                                                   ORDER BY PUBLISHED_DATE ASC