LOAD DATA LOCAL INFILE '/home/lightt77/abhishek/coding/open source/myprojects/cet-decoded/SqlScripts/v1/csvs/Exercise.csv' 
INTO TABLE Exercise
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;