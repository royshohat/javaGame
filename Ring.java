public class Ring extends Weapon{
        // opening statement: none
        public String toString(){
            return "ring"; // returns the string representation of the Ring
        }
        // closing statement: returns "ring" as the string representation of the Ring
    
        // opening statement: Weapon
        public Integer stronger(Weapon other){
            return other.strongerring(this); // delegates the strength comparison to the other weapon
        }
        // closing statement: determines the strength of the current Ring against another weapon
    
        // opening statement: Ring
        public Integer strongerring(Ring other){
            return 0; // returns 0, indicating that the two Rings are equally strong
        }
        // closing statement: compares the strength of two Rings and returns 0 for equality
    
        // opening statement: Sword
        public Integer strongersword(Sword other){
            return -1; // returns -1, indicating that the Sword is stronger than the Ring
        }
        // closing statement: compares the strength of the Ring against a Sword
    
        // opening statement: Fireball
        public Integer strongerfireball(Fireball other){
            return 1; // returns 1, indicating that the Ring is stronger than the Fireball
        }
        // closing statement: compares the strength of the Ring against a Fireball
}