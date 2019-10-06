//I worked on the homework assignment alone, using only course materials.
package hw09;
/**
 * @author mikhailbudko
 * @version 1.0
 */
public class Spell {
    private String name;
    private int damage;
    /**
     *
     * @return name of spell
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @return spell damage
     */
    public int getDamage() {
        return damage;
    }
    /**
     * Creates a spell object
     * @param name spell name
     * @param damage spell damage
     */
    public Spell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    /**
     *
     * @return String that describes spell
     */
    @Override
    public String toString() {
        return this.name + ": " + this.damage + " attack power";
    }
    /**
     * Compares two spell objects
     * @param obj another spell
     * @return boolean whether two spells are equal
     */
    @Override
    public boolean equals(Object obj) {
        Spell other = (Spell) obj;
        boolean same = false;
        if (obj instanceof Spell) {
            same = (this.name.equals(other.name) && this.damage == other.damage);
        }
        return same;
    }
    /**
     * Assigns hashcode to a spell
     * @return spell hashcode
     */
    @Override
    public int hashCode() {
        int result = 0;
        result += this.damage + this.name.hashCode();
        return result;
    }
}
