
import org.json.JSONObject;



public class Dungeon{
  
    private static JSONObject jobj;

    private static Dungeon instance;

    static {
        instance = new Dungeon();
    }

    public static final Dungeon GetInstance()
    {
        jobj = JsonToken.GetjObj();
        return instance;
    }
    private Dungeon() {

    }

    public String getName ()
    {
        return jobj.getJSONObject("Dungeon").getString("Dungeon_name");
    }

    public Level getEnter()
    {
        return Level.create(jobj.getJSONObject("Levels").getJSONObject(jobj.getJSONObject("Dungeon").getString("Start_lvl")));
    }

}
