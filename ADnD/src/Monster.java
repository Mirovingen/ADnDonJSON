public class Monster {
    private int Hp;
    private int Mp;
    private final String Name;
    private int lvl;
    private Level current_level;
    private final Creature creature;
    //private Status status;


    public static Monster NewMonster(String Name, String Race, String Class)
    {
        return new Monster(Name, Race, Class);
    }
    private Monster(String Name, String Race, String Class) {
        this.creature = new Creature.builder().Race(Race).Class(Class).build();
        this.Hp = 50;
        this.Mp = 20;
        this.Name = Name;
        this.lvl = 1;

    }

    public String getName() {
        return Name;
    }

    public int getHp() {
        return Hp;
    }

    public int getMp() {
        return Mp;
    }

    public void act(Status st)
    {
       st.damage = 10;
       st.heal   = 0;
    }



    public void set_status(Status status){
        Hp -= status.damage;
        Hp += status.heal;
    }



}
