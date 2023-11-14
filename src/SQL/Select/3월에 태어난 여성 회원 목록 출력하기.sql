SELECT member_id,
       member_name,
       gender,
       to_char(date_of_birth, 'yyyy-mm-dd') as date_of_birth
FROM member_profile
WHERE extract(month from date_of_birth) = 3
  and gender = 'W'
  and tlno is not null
ORDER BY member_id;