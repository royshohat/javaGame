public class Fireball extends Weapon{
    // opening statement: none
    public String toString(){
        return "fbll";
    }
    // closing statement: returns the string representation of the Fireball ("fbll")

    // opening statement: Weapon
    public Integer stronger(Weapon other){
        return other.strongerfireball(this);
    }
    // closing statement: compares this Fireball with another Weapon and delegates to the appropriate method

    // opening statement: Ring
    public Integer strongerring(Ring other){
        return -1;
    }
    // closing statement: returns -1, indicating this Fireball is weaker than a Ring

    // opening statement: Sword
    public Integer strongersword(Sword other){
        return 1;
    }
    // closing statement: returns 1, indicating this Fireball is stronger than a Sword

    // opening statement: Fireball
    public Integer strongerfireball(Fireball other){
        return 0;
    }
    // closing statement: returns 0, indicating this Fireball is equal in strength to another Fireball
}
