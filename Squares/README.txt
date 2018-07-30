Squares

A few days earlier a certain mathematician had been fired from his job so he has made up his mind to take revenge on his former employers and has changed all the numbers in their databases to their corresponding forms in different numerical systems using different bases. At the beginning it seemed to everyone to be just a stupid joke and hopefully they would soon find the correct data hidden somewhere. They were wrong, because even the backup database copies have been changed. The only hint, they were given was that all the data had been transformed to systems with such a base that it is the smallest base in which input numbers are squares. 

Your task is to find these bases. You need to hurry up, because the whole firm’s activity depends on your database fix. You may however assume that: 
• for each number, there exists a sought base and it is less than 100 
• all the digits in input numbers are characters 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 
• each number written in decimal system is smaller that 1000000000 

Input:
Data set consists of lines containing single numbers. Occurrence of ‘0’ means the end of data set (0 is not treated as valid data). 

Output: 
For each number you should find a smallest base of a numerical system in which this number is a square of some other number. Each number should be outputted in separate line. 

Sample Input:
61
1100 
509 
510 
1013 
0 

Sample Output:
8 
3 
12 
16 
6