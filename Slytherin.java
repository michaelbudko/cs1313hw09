//I worked on the homework assignment alone, using only course materials.
package hw09;
import java.util.Random;
/**
 * @author mikhailbudko
 * @version 1.0
 */
public class Slytherin extends Wizard {
    /**
     * Creates a Slytherin object
     * @param name name of wizard
     */
    public Slytherin(String name) {
        super(name, "Green", getMaxHealth(), getAttackPower(), getSpellbook());
    }
    /**
     *
     * @return max health of wizard
     */
    public static int getMaxHealth() {
        Random random = new Random();
        return random.nextInt(6) + 22;
    }
    /**
     *
     * @return attack power of wizard
     */
    public static int getAttackPower() {
        Random random = new Random();
        return random.nextInt(3) + 5;
    }
    /**
     *
     * @return spell array of wizard
     */
    public static Spell[] getSpellbook() {
        return new Spell[]{new Spell("Expulso", 3),
                           new Spell("Levicorpus", 2),
                           new Spell("Oppugno", 1),
                           new Spell("Flipendo", 1),
                           new Spell("Wingardium Leviosa", 0)};
    }
}
