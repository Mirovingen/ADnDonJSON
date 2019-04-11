import org.json.JSONObject;


public class Level {
    private String Name;
    private String level_id;
    private JSONObject level;
    private static JSONObject jobj;

    public static Level create(JSONObject name) {
        return new Level(name);
    }

    private Level(JSONObject level) {
        this.Name = level.getString("Level_name");
        this.level_id = level.toString();
        jobj = JsonToken.GetjObj();
        this.level = level;

    }

    public String getName() {
        return this.Name;
    }


    public Level Next() {
        String exit;
        int num = 1;
        int count = level.getJSONArray("Exits").length();
        if (count == 0) {
            System.out.println("It is dead end\nWant to go back? Y/N");

            return this;
        }
        if (count > 1) {
            System.out.println("There are " + count +" exits\nWhich one do you prefer?\n1,2,3...");
            num = Integer.parseInt(Engine.getInput());
        }
        if (num <= count && num > 0)
            exit = level.getJSONArray("Exits").getString(num - 1);
        else
            exit = level.getJSONArray("Exits").getString(count - 1);
        if (exit.equals("Exit"))
            return null;
        return create(getLevel(exit));
    }

    public static JSONObject getLevel(String level_id) {

        return  JsonToken.GetjObj().getJSONObject("Levels").getJSONObject(level_id);
    }
    
    public void Explore()
    {

        if (level.getJSONArray("Monsters").length() != 0 ) {
            String Race  = level.getJSONArray("Monsters").getJSONObject(0).getString("Race");
            String Class = level.getJSONArray("Monsters").getJSONObject(0).getString("Class");
            System.out.println("There are monsters nearby");
            Monster monster = Monster.NewMonster("Braa", Race, Class);
            System.out.println("Wild " + monster.getName() + " has appeared");
            Engine.Fight(monster);
        }
    }
}
