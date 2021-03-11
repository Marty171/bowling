## EWON Bowling

## Build
- Build avec maven (mvn clean install)

## Test du programme
A la racine du projet:

java -jar target/bowling-1.0.jar 1 1 9 1

	1 : 1, 1 = 2
	2 : 9, / =  -
	-----------
	12

java -jar target/bowling-1.0.jar 1 1 9 1 10

	1 : 1, 1 = 2
	2 : 9, / = 22
	3 : X =  -
	-----------
	32

java -jar target/bowling-1.0.jar 1 1 9 1 10 1 1 9 0 5 3

	1 : 1, 1 = 2
	2 : 9, / = 22
	3 : X = 34
	4 : 1, 1 = 36
	5 : 9, - = 45
	6 : 5, 3 = 53
	-----------
	53

java -jar target/bowling-1.0.jar 1 1 9 1 10 1 1 0 10 5 3 7 2 4 6 10 10 3 7

	1 : 1, 1 = 2
	2 : 9, / = 22
	3 : X = 34
	4 : 1, 1 = 36
	5 : -, / = 51
	6 : 5, 3 = 59
	7 : 7, 2 = 68
	8 : 4, / = 88
	9 : X = 111
	10 : X, 3, / = 131
	-----------
	131

java -jar target/bowling-1.0.jar 1 1 9 1 10 10 10 6 2 7 3 10 0 9 2 8 10

	1 : 1, 1 = 2
	2 : 9, / = 22
	3 : X = 52
	4 : X = 78
	5 : X = 96
	6 : 6, 2 = 104
	7 : 7, / = 124
	8 : X = 143
	9 : -, 9 = 152
	10 : 2, /, X = 172
	-----------
	172
