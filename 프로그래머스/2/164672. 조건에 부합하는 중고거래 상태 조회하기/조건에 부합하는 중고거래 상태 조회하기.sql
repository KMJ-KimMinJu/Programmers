-- 코드를 입력하세요
SELECT B.BOARD_ID, B.WRITER_ID, B.TITLE, B.PRICE, 
(CASE WHEN B.STATUS = 'DONE' THEN '거래완료' 
    WHEN B.STATUS = 'RESERVED' THEN '예약중' 
    ELSE '판매중'
END)
AS 'STATUS'
FROM USED_GOODS_BOARD B
WHERE CREATED_DATE = '2022-10-05'
ORDER BY B.BOARD_ID DESC;