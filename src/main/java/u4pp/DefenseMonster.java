package u4pp;

//basically repeating same thing as Monster.java
public class DefenseMonster extends Monster{

    private int defense;

    public DefenseMonster (String name, int health, int attack, int exp, int defense){

        super (name, health, attack, exp);
        this.defense = defense;
    }

    public int getDefense(){
        return this.defense;
    }

    public void takeDamage(int damage){
        super.takeDamage(damage - this.defense);
    }

    public String toString(){
        return super.toString() + String.format(" Monster defense is %s.", this.defense);
    }
}
