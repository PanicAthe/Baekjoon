-- 우유와 요거트를 동시에 구입한 장바구니 아이디
SELECT DISTINCT(CART_ID)
FROM CART_PRODUCTS
WHERE CART_ID IN (SELECT CART_ID
                 FROM CART_PRODUCTS
                 WHERE NAME = 'Yogurt')
AND CART_ID IN (SELECT CART_ID
                 FROM CART_PRODUCTS
                 WHERE NAME = 'Milk')
ORDER BY CART_ID;