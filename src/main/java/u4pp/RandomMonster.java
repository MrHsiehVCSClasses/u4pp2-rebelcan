package u4pp;

//basically repeating the same thing as Monster.java
public class RandomMonster extends Monster{

    public RandomMonster(String name, int health, int attack, int exp){
        super (name, health, attack, exp);
    }

    public void takeTurn(Combatant target){

        if (Math.random() < 0.5){
            super.takeTurn(target);
        }
    }

    public String toString(){
        return super.toString() + " Monster only has a 50% chance of attacking.";
    }
    
}
