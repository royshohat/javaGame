// the Board
import java.awt.Point;
import java.util.Random;

public class Board{
    private final int SIZE = 10; // Board size final
    private Entity[][] matr; // the Board
    Random rnd = new Random();

    //Constract board
    public Board(){ 
        Entity[][] Board = new Entity[SIZE][SIZE];
        this.matr = Board;
        
    }
    // starting statement: Entity
    public void genterEnt(Entity e){ 
        int x = rnd.nextInt(SIZE);
        int y = rnd.nextInt(SIZE);
        while (true) { 
            if(matr[x][y] == null){
                // gets here if spot is empty
                matr[x][y] = e;
                break;
            }
            // generate new x,y if spot wasnt empty
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        }
    }
    // closing statement: adds Entity e to the board if spot empty, return nothing

    // opening statement: Entity, Point
    public void addEntity(Entity e, Point p){
        matr[(int) p.getY()][(int) p.getX()] = e;
    }
    // closing statement: puts Entity in Point, return nothing

    // opening statement: Point
    public void deleteEntity(Point p){
        matr[(int) p.getY()][(int) p.getX()] = null;
    }
    // closing statement: replace board in Point with null return nothing
    
    // openning statment: Point
    public Entity getEntity(Point p){
        return matr[(int) p.getY()][(int) p.getX()];
    }
    // closing statement: returns the entity in point

    // openning statement: Point
    public boolean isEmpty(Point p){
        return matr[(int) p.getX()][(int) p.getY()]==null;
    }
    // closing statement: returns true if the point is empty, false otherwise

    // opening statement: int, int
    public boolean isleagal(int x, int y){ 
        if(x>9 | x<0 | y>9 | y<0) return false; 
        return !(matr[y][x] instanceof Tree);
    }
    // closing statement: returns false if out of bounds or the spot contains a Tree, true otherwise

    // opening statement: String
    public boolean isvalid(String move){ 
        return (move.equals("a") | move.equals("s") | move.equals("d") | move.equals("w"));
    }
    // closing statement: returns true if the move is "a", "s", "d", or "w", false otherwise

    // opening statement: Point
    public boolean isplayer(Point pnt){ 
        return matr[(int) pnt.getY()][(int) pnt.getX()] instanceof Player;
    }
    // closing statement: returns true if the entity at the point is a Player, false otherwise

    // opening statement: Point
    public boolean iswepon(Point pnt) { 
        return matr[(int) pnt.getY()][(int) pnt.getX()] instanceof Weapon;
    }
    // closing statement: returns true if the entity at the point is a Weapon, false otherwise

    // opening statement: none
    public void printBoard(){ 
        for (int i = 0; i <(SIZE-1)*9; i++) System.out.print('-');
        System.out.println(' ');
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matr[i][j]==null) System.out.print("(\t)");
                else System.out.print("(" + matr[i][j].toString() + "\t)");
            }
            System.out.println("");
            for (int a = 0; a < SIZE*8+1; a++) System.out.print('-');
            System.out.println("");
        }
    }
    // closing statement: prints the board with each cell represented by its entity or empty space

    // opening statement: none
    public Point getInitialPosition() {
        int x = rnd.nextInt(SIZE);
        int y = rnd.nextInt(SIZE);
        while (true) { 
            if(matr[y][x] == null) return new Point(x,y);
    
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        }
    }
    // closing statement: generates and returns a random empty position on the board
}