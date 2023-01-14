# Refactoring Java

The code creates an information slip about movie rentals.
Rewrite and improve the code after your own liking.

Think: you are responsible for the solution, this is a solution you will have to put your name on.


## Handing in the assignment

Reason how you have been thinking and the decisions you took. 
You can hand in the result any way you feel (git patch, pull-request or ZIP-file).
Note: the Git history must be included.


## To run the test:

```
javac src/*.java
java -cp src Main
```

## Steps followed for Refactoring.
For maintaining the application simple , didn’t use any framework to avoid 
unnecessary installations of jars.

Removed if-else with Switch case and used seperate method for the same.

Covered negative scenarios with exception handling and by returning string value.

Moved the classes into different package for readability.

Used StringBuilder with append method as StringBuilder is faster, 
mutable and memory efficient.

Added a separated Dao class to fetch the movies.

Used Enum for Movie Types.

Added Constant class to handle all the constant values.

Updated few variable names to make it more meaningful.

Implemented logger using log4j to track the service.

Added junit test cases for testing multiple scenarios.

Maintained the code and approach in sync with the given code.


