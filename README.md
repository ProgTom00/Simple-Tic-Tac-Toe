## Table of contents

* [General info](#general-info)

* [Game navigation](#game-navigation)
  
* [Game rules](#game-rules)
  
* [Technologies](#technologies)
  
* [Setup](#Setup)

## General info
I present you a simple game called tic-tac-toe. The game is created for two players.

## Game navigation
To navigate through the game, just follow the options. You will use coordinates to play the game.

## Game rules
After the game starts, the board will be printed with information to enter the coordinates. 
The first player has to play as X, and their opponent plays as O. The game grid ix 3x3.
The coordinates must be entered as in the table below, where (1,1) is the top left corner,
(3,3) is the bottom right corner.

```
(1,1) (1,2) (1,3)
(2,1) (2,2) (2,3)
(3,1) (3,2) (3,3)
```
 
If the user enters non-numeric symbols in the coordinates input, or the user enters coordinates outside the 
game grid or if the cell is not empty error occurs. The player must enter the correct coordinates to continue the game.
If player entered correct coordinates, next move will make opponent. The game ends when someone wins or there is a draw.
Player wins when has three X’s or O's in a row or in columns or diagonally.

## Technologies
Project is created with:

IntelliJ IDEA Community Edition 2021.1.3 x64

## Setup
To start this game, just run main method from SimpleTicTacToe class.
