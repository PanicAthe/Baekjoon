-- 식품분류별로
-- 제일 비싼 식품의 분류, 가격 이름 조회
-- 식품분류가 '과자', '국', '김치', '식용유' 인 경우만 출력
-- 식품 가격 내림차순

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE)
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치','식용유')
    GROUP BY CATEGORY
)
ORDER BY MAX_PRICE DESC;