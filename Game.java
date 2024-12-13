import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public Game(){
        System.out.print("how much player are playing? ");
        int playersSum = scanner.nextInt(); // gets player amount from the user
        scanner.nextLine();
        Board b = new Board(); // creates new board 
        Queue<Player> playersQueue = new LinkedList(); // creates playersqueue
            
        
        for (int i = 0; i < 3; i++) b.genterEnt(new Tree()); // adds 3 trees to the board
        for (int i = 0; i < 2; i++) {
            b.genterEnt(new Ring()); // adds 2 rings to the board
            b.genterEnt(new Sword()); // adds 2 swords to the board
            b.genterEnt(new Fireball()); // adds 2 fireballs to the board
        }
        for (int i = 1; i <= playersSum; i++) {
            Player player = new Player("player" + i); // creates players with name 1 to players sum
            Point initialPosition = b.getInitialPosition(); // Get a initial position from the board

            player.setPos(initialPosition); // Set the player's position
            playersQueue.add(player); // adds player to the queue
            b.addEntity(player, initialPosition); // Add the player to the board
            
        }

        b.printBoard(); // print the board after puting all the entitys in the board
        
        // while running till there is only 1 player left
        while (playersSum > 1) { 
            String move; // creating move here to change him multiple times later in code

            // runing till player enter move valid and legal
            while (true) { 
                Player currentPlayerTurn = playersQueue.peek(); // saving the player whos turn is
                System.out.println(playersQueue.peek().getName() + " turns! pick a move: a,s,d,w "); // print the player name and tells hime it is turn now
                move = scanner.nextLine(); // gets the move

                Point currentPos = currentPlayerTurn.getPos(); // takes current pos to not call getpos() multiple times
                Point newPoint; // create the new Point that the layer want to move to 


                // enters only if move isnt legal
                if (!b.isvalid(move)){
                    System.out.println("move isnt legal! try again");
                    continue; // if move isnt  legal loops again 
                }
                switch (move) { // checks what dirction the player wnat to move to 
                    case "d" -> newPoint = new Point(currentPos.x + 1, currentPos.y);
                    case "a" -> newPoint = new Point(currentPos.x - 1, currentPos.y);
                    case "s" -> newPoint = new Point(currentPos.x, currentPos.y + 1);
                    case "w" -> newPoint = new Point(currentPos.x, currentPos.y - 1);
                    default -> {
                        System.out.println("Invalid move! Please choose a, s, d, or w.");
                        continue;
                        //gets here if move isnt valid 
                    }
                }
                // enters if the move isnt to a tree or out of bounds
                if (b.isleagal(newPoint.x, newPoint.y)){

                    // if it is not a player and not a wepon it gets here
                    if (!b.isplayer(newPoint) &&  !b.iswepon(newPoint)) {
                        b.addEntity(currentPlayerTurn, newPoint);
                        b.deleteEntity(currentPos);
                        currentPlayerTurn.setPos(newPoint);
                        break; // Exit the loop after a successful move
                    }

                    // if its a player it enter couse when interact with another player there will be a fight
                    else if(b.isplayer(newPoint)){
                        Player targetplayer = (Player) b.getEntity(newPoint);

                        // check for the emety of the weapon stacks of the players
                        if (targetplayer.stk.isEmpty() && !currentPlayerTurn.stk.isEmpty()) {
                            b.addEntity(currentPlayerTurn, newPoint);
                            b.deleteEntity(currentPos);
                            currentPlayerTurn.setPos(newPoint);
                            playersSum--;
                            searchAndDeleteByName(targetplayer.name, playersQueue);
                        }

                        else if (targetplayer.stk.isEmpty() && currentPlayerTurn.stk.isEmpty()) {
                            System.out.println("both stacks are empty! try your luck and roll the dice!\nif you get 4 or above, you will win!\npress enter to roll:");
                            scanner.nextLine();
                            Integer diceroll = rolldice();
                            if (diceroll>=4) {
                                System.out.println("you won the fight!");
                                b.addEntity(currentPlayerTurn, newPoint);
                                b.deleteEntity(currentPos);
                                currentPlayerTurn.setPos(newPoint);
                                playersSum--;
                                searchAndDeleteByName(targetplayer.name, playersQueue);
                                
                            }
                            else{
                                System.out.println("unfurtntly you lost");
                                b.addEntity(targetplayer, currentPos);
                                b.deleteEntity(newPoint);
                                targetplayer.setPos(currentPos);
                                playersSum--;
                                searchAndDeleteByName(currentPlayerTurn.name, playersQueue);
                            }
                        }
                        else if(!targetplayer.stk.isEmpty() && currentPlayerTurn.stk.isEmpty()){
                            b.addEntity(targetplayer, currentPos);
                            b.deleteEntity(newPoint);
                            targetplayer.setPos(currentPos);
                            playersSum--;
                            searchAndDeleteByName(currentPlayerTurn.name, playersQueue);
                        }

                    
                        else {
                            //gets here if both player have weapons to fight with
                            Integer fightResult = currentPlayerTurn.getWeapon().stronger(targetplayer.getWeapon());
                            switch (fightResult) {
                                case 1:  {
                                    // gets here if player won
                                    b.addEntity(currentPlayerTurn, newPoint);
                                    b.deleteEntity(currentPos);
                                    currentPlayerTurn.setPos(newPoint);
                                    playersSum--;
                                    searchAndDeleteByName(targetplayer.name, playersQueue);
                                }
                                case 0:{
                                    // gets here if player tie
                                    System.out.println("tie! try your luck and roll the dice!\nif you get 4 or above, you will win!\npress enter to roll:");
                                    scanner.nextLine();
                                    Integer diceroll = rolldice();
                                    if (diceroll>=4) {
                                        System.out.println("you won the fight!");
                                        b.addEntity(currentPlayerTurn, newPoint);
                                        b.deleteEntity(currentPos);
                                        currentPlayerTurn.setPos(newPoint);
                                        playersSum--;
                                        searchAndDeleteByName(targetplayer.name, playersQueue);
                                    }
                                    else{
                                        System.out.println("unfurtntly you lost");
                                        b.addEntity(targetplayer, currentPos);
                                        b.deleteEntity(newPoint);
                                        targetplayer.setPos(currentPos);
                                        playersSum--;
                                        searchAndDeleteByName(currentPlayerTurn.name, playersQueue);
                                    }
                                }
                                case -1:{
                                     // gets here if player lost
                                    b.addEntity(targetplayer, currentPos);
                                    b.deleteEntity(newPoint);
                                    targetplayer.setPos(currentPos);
                                    playersSum--;
                                    searchAndDeleteByName(currentPlayerTurn.name, playersQueue);
                                }
                                
                                default : {
                                    System.out.println("Invalid move! Please choose a, s, d, or w.");
                                    continue;
                                }
                            }

                        }
                        

                        break;
                    }
                    //enters if its weapon because in intrecation with a weapon the weapon will be add to the stack 
                    else if(b.iswepon(newPoint)){
                        Weapon pickup = (Weapon) b.getEntity(newPoint);
                        currentPlayerTurn.addWeapon(pickup);
                        System.out.println(currentPlayerTurn.name + "Stack of weapons: " + currentPlayerTurn.stk.toString());
                        b.addEntity(currentPlayerTurn, newPoint);
                        b.deleteEntity(currentPos);
                        currentPlayerTurn.setPos(newPoint);

                        break;
                    }
                }
                else System.out.println("move isn't legal!");
                
                
            }

            // Print the board after the move
            b.printBoard();

            // Advance to the next player
            
            playersQueue.add(playersQueue.remove());
        }
        // gets here if only one player left
        System.out.println("game over!!!");
        System.out.println(playersQueue.remove().name + " won!! ");

                
                
    }
    
    // opening statement: String, Queue<Player>
    public void searchAndDeleteByName(String name, Queue<Player> playersQueue){
        playersQueue.add(null);
        while (playersQueue.peek() != null) {
            if (playersQueue.peek().name.equals(name)) {
                playersQueue.remove();
                continue;
            }
            playersQueue.add(playersQueue.remove());
        }
    }
    // closing statement: removes a player by name from the queue

    // opening statement: none
    public Integer rolldice(){
        Random rnd = new Random();
        return rnd.nextInt(1, 6);
    }
    // closing statement: rolls a dice and returns a random number between 1 and 6
}
       
