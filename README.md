# COM-HELP-GRP
This repository is for all the projects discussed on the group.

Members
Student Number	Surname & Initials
23001082	Ngobeni HS
23005989	Mavhungu S
23023975	Mafune OZ
23032739	Bele AD
24007719	Sepatake ST
24046456	Rivombo NF
24038044	Radebe LK
24049873	Manenzhe ZH
24004763	Khoza T
24002372	Mamphekgo k
24001306	Munyai R
24012586	Mutele MG
22012756	RB Shumba
//////////////////////////////////////////////////////////////
Compiling and running

When the code runs:
1. The user will be asked a series of questions from name and surname to other more detailed questions about their gross income and expenses...
2. The user will have to chose yes or no to entering information
3. The project will use this information to track the balance of income and weather or not continuation is possible or not
4. In the case of overdraft the user will be given a chance to run through the whole project but pop up messages will be shown
5. Lastly the user will have to choose between a choice or 4 different vehicles and the project will check his/her affordability threshold of 30% of remaining balance.

Class Person

In the beginning there was class person close person has two initiations that will the public car in the project named privacy property we created at laws for every section of the code. In the beginning we imported Java X swing star becaused we wanted to report everything from the JOptionPane without issue or imported Java util array list so that we can use their  list to gather all the expenses together. We started with the class person and in class person we created public string name to get the name from the user and public string sending to get the surname from the user. Then created public string categories has groceries or technically city travel  and other things to name the expenses gathered and the public double that is used in case of extra expenses and that is everything initiated in class person.

Class Payslip

 Going to the next class payslip which extends from class person, is going to use the name and surname variables from class person  in payslip income and text deduction is created together information from the user and calculate how much the user pays for tax using the method called calculate tax percentage, which receives the income and tax deducted there is an if statement that checks if the income supplied by the user is a positive number and whether if tax deduction is also a positive number if not, there is a show error method created to show a quote please input valid non negative amount for tax deduction. There are methods calculate text percentage is public in case we want to use it in other classes as well as get valid double stray and show error message and that is the end of our code.

Class Expenditure

 The next class is class expenditure which extends payslip and is going to use methods and variables gathered in pace loop interest expenditure created a variable named estimated remains which is going to calculate the amount remaining of the expenses that have been paid and a rate list expenditure list is created to add expenses from the user which are water and electricity, groceries, travel costs, phone costs, and others.
 After the added a System.out.printIn is going to print the expenses and they are values and the estimated amount remaining is going to be calculated as estimated remains is equals to income minus  tax deduction minus total expenses. A boolean method is created called overspending which is going to receive any number and check if it's positive or negative.

Class Housing

 And we go to class housing options which extends expenditures and is going to use methods and values calculated and created from expenditures in housing option processes where the class housing is going to ask the user to choose between 20 or buying their house if the user rents it's going to ask for a valuable monthly payment and that amount is going to be subjected from the estimated value calculated in expenditures if the user chooses to buy a house then information like house costs total deposit interest rate and the length.
 Between 20 to 30 years to calculate the amount to pay monthly to pay off the loan for that period of time, after the information has been gathered the code is going to check if any of those values are negative and then if not a motorization table is going to be displayed and the end value is there estimated remains equals to estimated remains minus total deposit minus monthly payment and then trust car choice extends housing options and is going to ask the user to choose from an option of five cars different mix different prices different deposits different interest rates if the user has enough money remaining it is going to validate if a if the user qualifies to buy a car.
 The choices are Toyota, Corolla, Honda, Civic, Ford, Focus, BMW 3 Series, Tesla model 3 from an erase created containing all the choices and the amount of the cars is going to be displayed before the user asks these. The user is asked to enter a choice and after the user enters the choice the price deposit interest any insurance is going to be assigned to its values from the double array. The method overspending is used to check if the user and his or her remaining amount is negative or not, if not then the code continues check their affordability threshold of 30% and if user has not reached it or if the monthly payment of the car is less than the threshold the user qualifies to buy a car if not the user does not qualify to buy a car and lastly we check their main method which instantiates the housing options class and their car choice that gets remaining balance from housing option process and then it is done.
