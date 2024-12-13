import java.awt.Point;
public class Tree extends Entity{
        // opening statement: none
        public Tree(){
            // Default constructor for Tree, initializes a Tree entity with no specific position
        }
        // closing statement: creates a Tree entity with no specific position
    
        // opening statement: Point
        public Tree(Point p){
            super(); // Calls the superclass constructor
            // Constructor for Tree, initializes a Tree entity at the given position
        }
        // closing statement: creates a Tree entity with a specific position
    
        // opening statement: none
        public String toString(){
            return "tree"; // Returns the string representation of the Tree
        }
        // closing statement: returns "tree" as the string representation of the Tree
}
