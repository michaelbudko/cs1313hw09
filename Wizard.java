//I worked on the homework assignment alone, using only course materials.
package hw09;
import java.util.Random;
/**
 * @author mikhailbudko
 * @version 1.0
 */
public class Wizard {
    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private String favColor;
    private Spell[] spellbook;
    /**
     * Creates a wizard object
     * @param name wizard name
     * @param favColor favorite color
     * @param maxHealth wizard max health
     * @param attackPower wizard attack power
     * @param spellbook spell book of wizard
     */
    public Wizard(String name, String favColor, int maxHealth, int attackPower,
            Spell[] spellbook) {
        if (maxHealth > 0) {
            this.name = name;
            this.favColor = favColor;
            this.maxHealth = maxHealth;
            this.health = maxHealth;
            this.attackPower = attackPower;
            this.spellbook = spellbook;
        }
    }
    /**
     * Creates wizard object with default spellbook
     * @param name wizard name
     * @param favColor favorite color
     * @param maxHealth wizard max health
     * @param attackPower wizard attack power
     */
    public Wizard(String name, String favColor, int maxHealth, int attackPower) {
            this(name, favColor, maxHealth, attackPower,
                    new Spell[]{new Spell("Wingardium Leviosa", 0)});
    }
    /**
     *  Creates wizard object with default max health
     * @param name wizard name
     * @param favColor favorite color
     * @param attackPower wizard attack power
     * @param spellbook spell book of wizard
     */
    public Wizard(String name, String favColor, int attackPower,
            Spell[] spellbook) {
        this(name, favColor, 25, attackPower, spellbook);
    }
    /**
     * Creates a wizard object with default spellbook and max health
     * @param name wizard name
     * @param favColor favorite color
     * @param attackPower wizard attack power
     */
    public Wizard(String name, String favColor, int attackPower) {
        this(name, favColor, 25, attackPower,
                new Spell[]{new Spell("Wingardium Leviosa", 0)});
    }
    /**
     * Wizard chooses a spell from spellbook
     * @return spell from spellbook
     */
    public Spell castSpell() {
        Random random = new Random();
        int maxSpell = this.spellbook.length;
        int numSpell = random.nextInt(maxSpell);
        return spellbook[numSpell];
    }
    /**
     *
     * @return String that describes a wizard
     */
    @Override
    public String toString() {
        return this.name + " wishes to join the " + this.favColor
                + " house at Hogwarts! They have " + this.health
                + " health points and " + this.attackPower + " attack power.";
    }
    /**
     * Fight between two wizards
     * @param one wizard one
     * @param two wizard two
     */
    public static void duel(Wizard one, Wizard two) {
        while (one.health > 0 && two.health > 0) {
            if (one.health != one.maxHealth && one.health < two.health) {
                one.restoreHealth();
            } else if (two.health != two.maxHealth && two.health < one.health) {
                two.restoreHealth();
            }
            if (one.health < two.health) {
                one.attack(two);
                if (two.healthCheck(one)) {
                    two.attack(one);
                    one.healthCheck(two);
                }
            } else if (two.health < one.health) {
                two.attack(one);
                if (one.healthCheck(two)) {
                    one.attack(two);
                    two.healthCheck(one);
                }
            } else {
                one.attack(two);
                if (two.healthCheck(one)) {
                    two.attack(one);
                    one.healthCheck(two);
                }
            }
        }
        one.health = one.maxHealth;
        two.health = two.maxHealth;
    }
    /**
     * Interaction between two wizards that leads to a duel
     * @param other other wizard
     */
    public void interact(Wizard other) {
        System.out.println(this.name + ": Hey " + other.name
                + ", let's be friends!");
        duel(this, other);
    }
    /**
     * Compares two wizards
     * @param obj another wizard
     * @return boolean whether two wizards are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Wizard) {
            Wizard other = (Wizard) obj;
            boolean equalSpellbook = true;
            if (this.spellbook.length == other.spellbook.length) {
                int spellbookSize = this.spellbook.length;
                for (int i = 0; i < spellbookSize; i++) {
                    if (!this.spellbook[i].equals(other.spellbook[i])) {
                        equalSpellbook = false;
                    }
                }
            } else {
                equalSpellbook = false;
            }
            return (this.name.equals(other.name)
                    && this.maxHealth == other.maxHealth
                    && this.attackPower == other.attackPower
                    && this.favColor.equals(other.favColor)
                    && equalSpellbook);
        } else {
            return false;
        }
    }
    /**
     * generates hashcode for wizard
     * @return wizard hashcode
     */
    @Override
    public int hashCode() {
        int result = 0;
        int arrayHash = 0;
        for (int i = 0; i < this.spellbook.length; i++) {
            arrayHash += this.spellbook[i].hashCode();
        }
        result += this.name.hashCode() + this.maxHealth + this.attackPower
                + this.favColor.hashCode() + arrayHash;
        return result;
    }
    /**
     * Checks if health of wizard is more than 0
     * @param other other wizard
     * @return boolean whether check is more than 0
     */
    public boolean healthCheck(Wizard other) {
        if (this.health <= 0) {
            System.out.println(this.name + " falls to the ground. "
                    + other.name + " wins the duel!");
            return false;
        }
        return true;
    }
    /**
     * Restores health of wizard with 20% chance
     */
    public void restoreHealth() {
        Random random = new Random();
        int num = random.nextInt(10);
        if (num <= 1) {
            this.health += 3;
        }
        if (this.health - this.maxHealth > 0) {
            this.health = this.maxHealth;
        }
        System.out.println(this.name
                + " drinks an invigoration potion and restores 3 health! "
                + this.name + " now has " + this.health + " health.");
    }
    /**
     * One wizard deals damage to another wizard
     * @param other other wizard
     */
    public void attack(Wizard other) {
        Random random = new Random();
        Spell spell = this.spellbook[random.nextInt(this.spellbook.length)];
        int damage = this.attackPower + spell.getDamage();
        other.health -= damage;
        System.out.println(this.name + " casts " + spell.getName()
                + " and deals " + damage + " damage. " + other.name
                + " now has " + other.health + " health.");
    }
    public static void main(String[] args) {
    }
}
