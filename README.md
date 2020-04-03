# 12U-A4-DaleksGame

A simple turn based game I created in my introductory computer science course, and my first exposure to game/graphics development. This game is a simple turn based strategy game which allows the player to play as The Doctor (the green pin), and move around the map to try and kill all the Daleks. The rules are simple;

# Rules:
1. The Doctor (the green pin) can only move on square at a time in any direction (diagonal is allowed)
2. If The Doctor tries to move more than one square, he is teleported to a random square on the map
3. Daleks (black pin) will move one square at a time, once after every turn
4. If two daleks move to the same square they crash (become red pins), and die
5. If a Dalek moves onto the same square as The Doctor, he is captured (becomes yellow pin) and the game is lost
6. Once all Daleks have crashed The Doctor wins the game

___

### The game can be started with any grid size, and any number of enemy daleks.

___

#### Small Board Example

![Small Board](https://raw.githubusercontent.com/GNPower/12U-A4-DaleksGame/master/examples/dalek_game_small.PNG)

#### Medium Board Example

![Medium Board](https://raw.githubusercontent.com/GNPower/12U-A4-DaleksGame/master/examples/dalek_game_medium.PNG)

#### Large Board Example

![Large Board](https://raw.githubusercontent.com/GNPower/12U-A4-DaleksGame/master/examples/dalek_game_large.PNG)

___
# Playing The Game:

### The winning condition:

![Small Board](https://raw.githubusercontent.com/GNPower/12U-A4-DaleksGame/master/examples/daleks_win.gif)

### The losing condition:

![Small Board](https://raw.githubusercontent.com/GNPower/12U-A4-DaleksGame/master/examples/daleks_lose.gif)
