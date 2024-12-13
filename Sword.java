public class Sword extends Weapon{
        // opening statement: none
        public String toString(){
            return "swrd"; // returns the string representation of the Sword
        }
        // closing statement: returns "swrd" as the string representation of the Sword
    
        // opening statement: Weapon
        public Integer stronger(Weapon other){
            return other.strongersword(this); // delegates the strength comparison to the other weapon
        }
        // closing statement: determines the strength of the current Sword against another weapon
    
        // opening statement: Ring
        public Integer strongerring(Ring other){
            return 1; // returns 1, indicating that the Sword is stronger than the Ring
        }
        // closing statement: compares the strength of the Sword against a Ring
    
        // opening statement: Sword
        public Integer strongersword(Sword other){
            return 0; // returns 0, indicating that the two Swords are equally strong
        }
        // closing statement: compares the strength of two Swords and returns 0 for equality
    
        // opening statement: Fireball
        public Integer strongerfireball(Fireball other){
            return -1; // returns -1, indicating that the Fireball is stronger than the Sword
        }
        // closing statement: compares the strength of the Sword against a Fireball
}
