
WITH SKILL_VALUES AS (
    SELECT 
        (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') AS FE_CODE,
        (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') AS PY_CODE,
        (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') AS CS_CODE
)

SELECT GRADE, ID, EMAIL
FROM (
    SELECT 
        CASE 
            -- A: Front End 스킬이 있고 AND Python 스킬이 있는 경우
            WHEN (SKILL_CODE & FE_CODE) AND (SKILL_CODE & PY_CODE) THEN 'A'
            -- B: C# 스킬이 있는 경우
            WHEN (SKILL_CODE & CS_CODE) THEN 'B'
            -- C: 그 외에 Front End 스킬이 하나라도 있는 경우
            WHEN (SKILL_CODE & FE_CODE) THEN 'C'
        END AS GRADE, 
        ID, 
        EMAIL
    FROM DEVELOPERS, SKILL_VALUES
) AS RESULT
WHERE GRADE IS NOT NULL
ORDER BY GRADE ASC, ID ASC;