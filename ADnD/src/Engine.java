
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    static ArrayList<Hero> party = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private static JSONObject jobj = JsonToken.GetjObj();
    public static void main(String[] args) throws Exception
    {


        CreateHero();
        System.out.println("Wanna enter? Yes/No");
        String answer = getInput();
        if (answer.equals("Yes") || false)
        {
            Dungeon dungeon = Dungeon.GetInstance();
            System.out.println("Welcome to Dungeon, " + party.get(0).getName());

            party.get(0).Enter(dungeon);
            System.out.println(party.get(0).getCurrent_level().getName());
            do {
                party.get(0).moveTo(party.get(0).getCurrent_level().Next());
                System.out.println(party.get(0).getCurrent_level().getName());
                party.get(0).getCurrent_level().Explore();
            }while (party.get(0).getCurrent_level().Next() != null);




        }

//    Creature a = new Creature.builder().Race("Ork").Class("Wizard").build();
//    a.StatInfo();
//    a.SetSkills(1);



    }

    private void Init()
    {

    }

    private static void CreateHero() {
        System.out.println("Hello stranger.\nHow may I call you?");
        Hero hero = Hero.NewHero(getInput(), "Ork", "Wizard");
        party.add(hero);
        System.out.println(party.get(0).getName() + " has joined the party");


    }

    public static boolean Fight(Monster monster)
    {
        int turn = 1;
        while (monster.getHp() > 0 && party.get(0).getHp() > 0) {
            System.out.println("Turn " + turn);

            Status st = new Status(0,0);
            party.get(0).act(st);
            monster.set_status(st);
            System.out.println(party.get(0).getName() + " bites " + monster.getName() + " for " + st.damage);
            System.out.println(monster.getName() + " has " + monster.getHp() + " Hp left");
            turn++;
        }


        return true;
    }

    public static String getInput() {
        return scanner.nextLine();
    }





}

class Status {
    int damage;
    int heal;

    Status(int dmg, int heal) {this.damage = dmg; this.heal = heal;}

}




