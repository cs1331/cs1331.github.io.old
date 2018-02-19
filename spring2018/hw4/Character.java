public abstract class Character {
    private String name;
    private int level;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int health;
    private boolean isDead = false;

    public Character(String name, int seed) {
        //implement this constructor using constructor delegation
    }

    public Character(String name, int level,
                     int strength, int dexterity,
                     int intelligence, int wisdom) {
        //implement this constructor
    }

    public String getName() {
        //implement this method
        return null;
    }

    public int getLevel() {
        //implement this method
        return 0;
    }

    public void setLevel(int level) {
        //implement this method
    }

    public int getStrength() {
        //implement this method
        return 0;
    }

    public void setStrength(int strength) {
        //implement this method
    }

    public int getDexterity() {
        //implement this method
        return 0;
    }

    public void setDexterity(int dexterity) {
        //implement this method
    }

    public int getIntelligence() {
        //implement this method
        return 0;
    }

    public void setIntelligence(int intelligence) {
        //implement this method
    }

    public int getWisdom() {
        //implement this method
        return 0;
    }

    public void setWisdom(int wisdom) {
        //implement this method
    }

    public int getHealth() {
        //implement this method
        return 0;
    }

    public void setHealth(int health) {
        //implement this method
    }

    public boolean getIsDead() {
        //implement this method
        return false;
    }

    public void setIsDead(boolean isDead) {
        //implement this method
    }

    public abstract void levelUp();

    public abstract void attack(Character c);

    public abstract String toString();

}
