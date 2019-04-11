import org.json.JSONObject;

public class Hero{
    private int Hp;
    private int Mp;
    private final String Name;
    private int lvl;
    private Level current_level;
    private final Creature creature;


    public static Hero NewHero(String Name, String Race, String Class)
    {
        return new Hero(Name, Race, Class);
    }
    private Hero(String Name, String Race, String Class) {
        this.creature = new Creature.builder().Race(Race).Class(Class).build();
        this.Hp = 50;
        this.Mp = 20;
        this.Name = Name;
        this.lvl = 1;
    }

    public String getName() {
        return Name;
    }

    public void moveTo (Level level)
    {
        this.current_level = level;
        System.out.println(this.Name + " just entered " + level.getName());
    }

    public void Enter (Dungeon dungeon)
    {
        this.current_level = dungeon.getEnter();
        System.out.println(this.Name + " just entered " + dungeon.getName());
    }

    public Level getCurrent_level() {
        return current_level;
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
