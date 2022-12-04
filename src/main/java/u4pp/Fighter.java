package u4pp;

public class Fighter extends Combatant {

    private int level;
    private int experience;
    private int focusStacks;
    private boolean blocking;

    public Fighter(String name, int maxHealth, int attack){
        super(name, maxHealth, attack);
        this.level = 1;
        this.experience = 0;
        this.focusStacks = 0;
        this.blocking = false;

    }

    public int getEXP(){
        return this.experience;
    }

    public int getFocusStacks(){
        return this.focusStacks;
    }

    public int getLevel(){
        return this.level;
    }

    public boolean getIsBlocking(){
        return this.blocking;
    }

    public void attack(Combatant target){
        int damage = this.getAttackPower() * (int)Math.pow(2, this.getFocusStacks());
        target.takeDamage(damage);
        this.focusStacks = 0;
        
    }

    public void block(){
        this.blocking = true;

    }

    public void focus(){
        this.focusStacks += 1;
    }

    public void gainEXP(int exp){
        this.experience += exp;
        while (this.experience >= this.level){
            this.experience -= this.level;
            this.level += 1;
            this.setMaxHealth(this.getMaxHealth() + 5);
            this.setAttackPower(this.getAttackPower() + 1);
            this.setHealth(this.getMaxHealth());
        }
    }
    
    public void takeDamage (int damage){
        if (this.blocking){
            damage = Math.floorDiv(damage, 2);
        }
        super.takeDamage(damage);
        this.blocking = false;
    }
    
    public String toString(){
        return super.toString() + String.format(" Fighter's level is %s, experience is %s, number of focus stacks is %s, blocking status is %s", this.level, this.experience, this.focusStacks, this.blocking);
    }
}
