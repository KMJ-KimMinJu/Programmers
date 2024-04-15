-- 코드를 입력하세요
SELECT PRODUCT.PRODUCT_CODE, SUM(PRODUCT.PRICE * OFFLINE_SALE.SALES_AMOUNT) SALES
FROM PRODUCT
JOIN OFFLINE_SALE ON PRODUCT.PRODUCT_ID = OFFLINE_SALE.PRODUCT_ID
GROUP BY OFFLINE_SALE.PRODUCT_ID
ORDER BY SUM(PRODUCT.PRICE * OFFLINE_SALE.SALES_AMOUNT) DESC,PRODUCT.PRODUCT_CODE;