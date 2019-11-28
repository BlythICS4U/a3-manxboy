# a3 Assignment 3

Before you start your work, ensure that you have cloned this repository and created a develop branch. When you have completed the assignment, commit to your develop branch and create a pull request.

## Problem 1 : Report Card Parser

A ReportCardParser project has been provided for you.  This project contains code to get you started and a set of text files containing report card data (there are different sets of text files for Windows vs. non-Windows operating systems).  If you examine the report card text files, you will see that there are 3 different types:

**Type 1 Example**

```
Name: Tony Stark
DOB: 01/19/02

English				85
Business Studies		76
Computer Science		95
Calculus			82
Principles of Mathematics	78
Chemistry			56
Physics				90
Biology				63
```

**Type 2 Example**

```
Natasha Romanoff
02/25/02

English,96,Business Studies,97,Computer Science,80,Calculus,74,Principles of Mathematics,79,Chemistry,85,Physics,72,Biology,78
```

**Type 3 Example**

```
Name: Carol Danvers
Date of Birth: 04/28/02

English	Business Studies	Computer Science	Calculus	Principles of Mathematics	Chemistry	Physics	Biology
96	97			80			74		79				85		72	78
```

A **Main.java** file has been provided for you.  Within this file is a fully implemented **main** method that, when the rest of the program is implemented, will do the following:
- Parse all of the report card files and store the information in an array of ReportCard objects
- Find the student with the highest average
- Find the best course for each student
- Calculate the average mark for several of the courses

### Task 1

There are 3 parser classes: **ReportCardParserType1, ReportCardParserType2** and **ReportCardParserType3**.  These classes correspond to the 3 different report card types.  These classes all implement the **IReportCardParser** interface.  However, the **parse** method in each of the parser classes is missing (they all simply return *null* at the moment).  Provide a proper implementation for each of these **parse** methods.  With correct implementations, all 9 report card text files should should be successfully parsed, and the information should be correctly stored in ReportCard objects array.

### Task 2

The **ReportCardStats** class is responsible for the following:
- Finding the student with the highest average
- Finding the best subject for a given report card
- Calculating the average mark for a given subject

Provide implementations for the methods in this class.

### Task 3

The empty test case class **ReportCardStatsTest** is provided.  Implement the tests in this class to ensure that your methods in **ReportCardStats** are correct.

### Task 4

You've probably noticed that there is a bit of common functionality in the 3 parser classes (i.e. the storing of the file path, code to open and close text files).  Introduce a common base class called **AbstractReportCardParser**.  This class should have the following characteristics:
- It should be defined as abstract
- It should implement the **IReportCardParser** interface
- It should contain all of the common code from the 3 parser classes

Once this class has been created, the 3 parser classes can be updated to extend this abstract class (rather than implementing the **IReportCardParser** interface).

## Problem 2 : Tic-tac-toe

A TicTacToe project has been provided for you.  However, the code is incomplete.  It builds, and the main method in TicTacToeRunner will attempt to play the game - but there there is necessary logic missing in the TicTacToe class (comments indicate where real implementations are needed).  What follows is a description of the methods in TicTacToe and their purpose.

**Fields**

Name | Description
--- | ---
board	| a two-dimensional array of chars

**Methods**

Signature | Description
--- | ---
TicTacToe() |	the default constructor, which just creates the two-dimensional array and fills each slot with  ' ' (a blank space) and initializes the other attributes
boolean isWinner(char p) |	returns true if the letter passed in currently has three in a row. That is, isWinner('X') will return true if X has won, and isWinner('O') will return true if O has won
boolean isFull() |	returns true if nine turns have been played and false otherwise
boolean isCat() |	returns true if all nine spaces are filled AND neither X nor O has won
boolean isValid( int r, int c ) |	returns true if the given row and column corresponds to a valid space on the board
char playerAt( int r, int c ) |	returns the character representing the piece at the given location. Should return either ' ', 'X', or 'O'.
void displayBoard()	| displays the current board on the screen
void playMove(char p, int r, int c)	| allows the given player to place their move at the given row and column. The row and column numbers are 0-based, so valid numbers are 0, 1, or 2

### Task 1

Before updating any code, use the descriptions above to properly document the TicTacToe class.  Use the best practices discussed in class.

### Task 2

Implement the empty methods in the TicTacToe class.  Ensure the methods function as according to the descriptions above.  Once the methods have been properly implemented, running the main method in TicTacToeRunner should allow for a proper game of tic-tac-toe to be played.

### Task 3

Fill in the empty test cases in TicTacToeTest.  Do your best to fully test all of the methods listed in the test file.  Pay special attention to the isWinner method (the last thing we need is the wrong winner being declared).

### Task 4

Add another class called TicTacToeAI.  This will serve as a computer opponent (the human will play as 'X', the AI will play as 'O').  The AI will need to keep track of the game board, so when a human chooses a square, the TicTacToeAI class will need a method to tell it what row and column were chosen by the human.  The AI will also need a "choose square" method, which returns the row and column chosen by the AI.

Update the TicTacToeRunner main method so that when it is 'O's turn, instead of getting the input from the console, the runner instead asks the AI object for its square choice.  The human 'X' player will still play from the console as usual.

To start, you can have the AI be really dumb and pick the first empty square it finds.  Ideally, you can make the AI a bit smarter and actually try to win the game.

