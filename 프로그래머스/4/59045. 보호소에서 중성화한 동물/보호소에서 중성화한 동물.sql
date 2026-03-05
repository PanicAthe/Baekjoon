-- 보호소에 들어와서 나갈 때, 중성화된 동물
SELECT ANIMAL_ID, ANIMAL_TYPE, NAME
FROM ANIMAL_INS
WHERE ANIMAL_ID IN (SELECT ANIMAL_ID
                   FROM ANIMAL_INS
                   WHERE SEX_UPON_INTAKE LIKE '%Intact%')
AND ANIMAL_ID IN (SELECT ANIMAL_ID
                 FROM ANIMAL_OUTS
                 WHERE SEX_UPON_OUTCOME LIKE '%Neutered%' 
                 OR SEX_UPON_OUTCOME LIKE '%Spayed%');