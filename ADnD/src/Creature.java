import org.json.JSONArray;
import org.json.JSONObject;


import java.util.HashSet;


public class Creature {
    private int INT;
    private int STR;
    private int AGL;
    private final String Class;
    private HashSet<String> tags;
    private static JSONObject jobj = JsonToken.GetjObj();
    private HashSet<String> skills;


    public static class builder
    {
        private int INT;
        private int STR;
        private int AGL;
        private String Class;
        private HashSet<String> tags = new HashSet<>();


        public builder()
        {
            //required params

        }
        public builder Race(String race)
        {
            JSONArray arr = jobj.getJSONObject("Creatures").getJSONArray("Template");

            arr.forEach(s->{
                JSONObject obj = (JSONObject) s;
                if (obj.getString("Race").equals(race)) {
                    INT = obj.getInt("INT");
                    STR = obj.getInt("STR");
                    AGL = obj.getInt("AGL");
                    tags.add(race);
                    return;
                }
            });
            return this;
        }
        public builder Class(String Class)
        {
            JSONArray arr = jobj.getJSONObject("Classes").getJSONArray("Template");
            arr.forEach(s-> {
                if (s.toString().equals(Class))
                    this.Class = s.toString();
                    });
            tags.add(Class);
            return this;
        }

        public Creature build(){
            return new Creature(this);
        }


    }
    private Creature(builder builder) {
        INT = builder.INT;
        AGL = builder.AGL;
        STR = builder.STR;
        Class = builder.Class;
        tags = builder.tags;
    }
    public void StatInfo()
    {
        System.out.println( "INT : " + this.INT + "\n" +
                            "STR : " + this.STR + "\n" +
                            "AGL : " + this.AGL + "\n" +
                            tags );
    }

    public void SetSkills(int num)
    {
        jobj.getJSONObject("Skills").getJSONArray(this.Class).forEach(s->System.out.println(s.toString()));
    }

}
