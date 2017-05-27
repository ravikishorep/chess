# chess
Sample chess game

# Prerequisites
1) JDK 1.8
2) Maven

# Steps to Build & execute
1) Pull the repo
2) Run mvn clean package
3) Run java -jar target/app-0.1.0.jar 

# APIs
1) Create Board - http://localhost:8080/game?playerOneName=abc&playeTwoName=efg (GET)
2) Reset Game - http://localhost:8080/game/reset (GET)
3) Move Piece - http://localhost:8080/game (POST w/ params startRow, startColumn, endRow, endColumn) 

# Note
Move functionality is implemented only for Pawn. 
