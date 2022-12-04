package u4pp;

public class Combatant {
    private String name;
    private int maxHealth;
    private int attack;
    private int health;

    //setting up constructor
    public Combatant(String name, int maxHealth, int attack){ 
        this.health = maxHealth; 
        this.maxHealth = maxHealth;
        this.name = name;
        this.attack = attack;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public int getAttackPower(){
        return this.attack;
    }

    //setting health and boundaries to make sure minimum health can be 0 & health is equal to possible max health
    public void setHealth(int health){
        if (health < 0){
            this.health = 0;
        }
        else if (health > this.maxHealth){
            this.health = this.maxHealth;
        }
        else {
            this.health = health;
        }
    }

    public void setMaxHealth(int health){
        if (health <= 0){
            this.maxHealth = 1;
        }
        else if (health < this.health){
            this.health = health;
            this.maxHealth = health; 
        }
        else {
            this.maxHealth = health;
        }
    }

    //making sure attack power is positive and deals actual damage
    public void setAttackPower(int attackPower){
        if (attackPower < 0){
            this.attack = 0;
        }
        else {
            this.attack = attackPower;
        }
    }

    //directly affecting health
    public void takeDamage(int damage){
        if (damage < 0){
            System.out.println("Cannot take negative damage.");
        }
        else {
            setHealth(this.health - damage);
        }
    }

    //as long as health is greater than 0, combatant can fight
    public boolean canFight(){
        return health > 0;
    }

    public String toString(){
        return String.format("Character's name is %s, health is %s, maxHealth is %s, attack is %s.", this.name, this.health, this.maxHealth, this.attack);
    }
}
