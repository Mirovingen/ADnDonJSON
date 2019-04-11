import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonToken {
    private static JSONTokener jtoken;
    private static JsonToken token;
    private static JSONObject jobj;

    static {
        try {
            token = new JsonToken();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static final JSONObject GetjObj()
    {
        return jobj;
    }
    public JsonToken() throws FileNotFoundException {
        FileReader reader = new FileReader("parseme.json");
        jtoken = new JSONTokener(reader);
        jobj   = new JSONObject(jtoken);
    }

}
