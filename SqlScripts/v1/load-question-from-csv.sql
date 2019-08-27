LOAD DATA LOCAL INFILE '/home/lightt77/abhishek/coding/open source/myprojects/cet-decoded/SqlScripts/v1/csvs/Question.csv' 
INTO TABLE Question
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;