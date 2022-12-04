package u4pp;
import java.util.Scanner;


public class MonsterFighter {
    private InputHelper IH;
    public MonsterFighter(){
        System.out.println( // looks a little weird because need to use double backslash to print 1 backslash
        "_______  _______  _        _______ _________ _______  _______    _______ _________ _______          _________ _______  _______ \n" +
        "(       )(  ___  )( (    |(  ____ \\\\__   __/(  ____ \\(  ____ )  (  ____ \\\\__   __/(  ____ \\|\\     /|\\__   __/(  ____ \\(  ____ )\n" +
        "| () () || (   ) ||  \\  ( || (    \\/   ) (   | (    \\/| (    )|  | (    \\/   ) (   | (    \\/| )   ( |   ) (   | (    \\/| (    )|\n" +
        "| || || || |   | ||   \\ | || (_____    | |   | (__    | (____)|  | (__       | |   | |      | (___) |   | |   | (__    | (____)|\n" +
        "| |(_)| || |   | || (\\ \\) |(_____  )   | |   |  __)   |     __)  |  __)      | |   | | ____ |  ___  |   | |   |  __)   |     __)\n" +
        "| |   | || |   | || | \\   |      ) |   | |   | (      | (\\ (     | (         | |   | | \\_  )| (   ) |   | |   | (      | (\\ (   \n" +
        "| )   ( || (___) || )  \\  |/\\____) |   | |   | (____/\\| ) \\ \\__  | )      ___) (___| (___) || )   ( |   | |   | (____/\\| ) \\ \\__\n" +
        "|/     \\|(_______)|/    )_)\\_______)   )_(   (_______/|/   \\__/  |/       \\_______/(_______)|/     \\|   )_(   (_______/|/   \\__/");
    }

    public void play(Scanner sc){
        this.IH = new InputHelper(sc);

        System.out.println("Type in your character's name!");
        String name = sc.next();
        Fighter mc = new Fighter(name, 100, 10);
        System.out.println("\nThis is your character! \n" + mc);

        Monster normal = new Monster("Mariah Carey" , 50, 5, 5);
        fight(mc, normal);

        RandomMonster random = new RandomMonster("Steve Harvey", 35, 3, 3);
        fight(mc, random);

        DefenseMonster defense = new DefenseMonster("Hsieh", 70, 15, 6, 10);
        fight(mc, defense);
    
    }
    private void fight(Fighter f, Monster m){
        System.out.println("\nYou found a monster! \n" + m);
        while (f.getHealth() != 0 && m.getHealth() != 0){
            int action = this.IH.getIntegerInput("\nChoose your next action!: (1) to attack, (2) to focus, (3) to block", 1, 3);
            if (action == 1){
                f.attack(m);
                System.out.println("You attacked! Monster's health is " + m.getHealth());
            }
            else if (action == 2){
                f.focus();
                System.out.println("You focused! Monster's health is " + m.getHealth());
            }
            else {
                f.block();
                System.out.println("You blocked! Monster's health is " + m.getHealth());
            }

            m.takeTurn(f);
            System.out.println("Monster took a swing! Current health is " + f.getHealth());

        }


        if (f.getHealth() == 0){
            System.out.println("You died! Game Over. :( ");
            System.exit(0);
        }
        else {
            System.out.println("Congrats! You defeated the monster! :D ");
        }
    }
    
}
