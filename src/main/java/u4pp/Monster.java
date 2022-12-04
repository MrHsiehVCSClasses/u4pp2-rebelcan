package u4pp;

public class Monster extends Combatant{

    private int exp;

    public Monster(String name, int health, int attack, int exp){
        super(name, health, attack);
        if (exp < 0){
            this.exp = 0;
        }
        else {
            this.exp = exp;
        }
        
    }

    public int getExpGiven(){
        return this.exp;
    }

    public void takeTurn(Combatant target){
        target.takeDamage(this.getAttackPower());
    }

    public String toString(){
        return super.toString() + String.format(" When defeated, Monster gives %s EXP.", this.exp);
    }
}
