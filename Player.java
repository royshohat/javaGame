import java.awt.Point;
import java.util.Stack;

public class Player extends Entity{
    Stack<Weapon> stk = new Stack<>();
    String name; 
        // opening statement: Point, Stack<Weapon>, String
        public Player(Point p, Stack<Weapon> stk, String name){ 
            super(); // calls the constructor of the parent class
            this.stk = stk; // initializes the weapon stack
            this.name = name; // sets the player's name
        }
        // closing statement: constructs a player with a position, a weapon stack, and a name
    
        // opening statement: String
        public Player(String name){
            this.name = name; // sets the player's name
        }
        // closing statement: constructs a player with a name
    
        // opening statement: Weapon
        public void addWeapon(Weapon w){
            stk.add(w); // adds the weapon to the stack
        }
        // closing statement: adds a weapon to the player's weapon stack
    
        // opening statement: none
        public Weapon getWeapon(){
            return stk.pop(); // removes and returns the top weapon from the stack
        }
        // closing statement: retrieves and removes the top weapon from the player's stack
    
        // opening statement: none
        public String toString(){
            return "pr" + name.substring(6); // returns a string representation of the player
        }
        // closing statement: returns a shortened string representation of the player's name
    
        // opening statement: none
        public String getName(){
            return this.name; // returns the player's name
        }
        // closing statement: retrieves the player's name


    


}
