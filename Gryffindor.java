//I worked on the homework assignment alone, using only course materials.
package hw09;
import java.util.Random;
/**
 * @author mikhailbudko
 * @version 1.0
 */
public class Gryffindor extends Wizard {
    /**
     * Creates a Gryffindor object
     * @param name name of Wizard
     */
    public Gryffindor(String name) {
        super(name, "Scarlet", getMaxHealth(), getAttackPower(), getSpellbook());
    }
    /**
     *
     * @return max health of wizard
     */
    public static int getMaxHealth() {
        Random random = new Random();
        return random.nextInt(6) + 25;
    }
    /**
     *
     * @return attack power of wizard
     */
    public static int getAttackPower() {
        Random random = new Random();
        return random.nextInt(3) + 4;
    }
    /**
     *
     * @return spell array of wizard
     */
    public static Spell[] getSpellbook() {
        return new Spell[]{new Spell("Expecto Patronum", 3),
                           new Spell("Expelliarmus", 2),
                           new Spell("Ridikkulus", 1),
                           new Spell("Wingardium Leviosa", 0)};
    }
}
