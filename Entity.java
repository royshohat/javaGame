import java.awt.Point;

public abstract class Entity {
    protected Point pos; // the postion of the entity

    // opening statement: none
    public Point getPos() {
        return pos;
    }
    // closing statement: returns the current position of the entity as a Point object

    // opening statement: Point
    public void setPos(Point pos) {
        this.pos = pos;
    }
    // closing statement: sets the position of the entity to the given Point object
    
}
