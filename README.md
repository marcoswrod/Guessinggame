 *  Number Guessing Game 
A Java based number guessing game
Includes things such as difficulty levels, input validation, replay mode, and tracks your best score.  
Built as an enhanced version of a CIT-111 class assignment I had. 

*Difficulty Levels
Choose between:
Easy: 1–50  
Meeium: 1–100  
Hard: 1–500  

Each difficulty adjusts the random number range.

* Intelligent Input Handling
The game includes:
- Checks non-number responses
- Range checking  
- Can handle invalid responses 

The program never crashes, even if the user enters letters or symbols.

* Replay
After each game, the user can choose to:
- Play again  
- Or exit cleanly  

* Best Score Tracking
The program keeps track of your lowest number of attempts during the whole session.

* Modular Code Design
The game is organized into clean and reusable methods, this includes:
- chooseDifficulty
- playGame
- getValidInt
- askToPlayAgain

This keeps  logic separated and improves maintainability.


