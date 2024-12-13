# Java Game - 10x10 Board Game

## Description

This is a simple text-based game implemented in Java. The game takes place on a 10x10 board and involves players interacting with various entities, including trees, weapons, and other players. The game mechanics are based on turn-based movement and combat, where players collect weapons and battle each other.

### Entities:
- **Trees**: 3 trees are placed randomly on the board. Players cannot move onto a square occupied by a tree.
- **Weapons**: Three types of weapons are included in the game:
  - Fireball
  - Sword
  - Ring
  There are 2 of each weapon type, and players can collect them by moving onto squares where they are placed.

### Game Rules:
1. Players take turns in a predefined order.
2. On each turn, players can move in one of four directions (R for Right, L for Left, U for Up, D for Down).
3. Players cannot move off the board or onto squares with trees.
4. If a player encounters a weapon, they pick it up and add it to their stack of weapons.
5. When two players meet on the same square, they battle by comparing the first weapon in their stack:
   - Fireball beats Sword
   - Sword beats Ring
   - Ring beats Fireball
6. If one player wins, the other player is removed from the game.

The game continues until only one player remains.

## Installation

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/royshohat/javaGame.git
