package Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Contains functions related to Serializing / Deserializing data
 *
 * @author Thomas Kwashnak
 * @version 1.0.0
 * @since 1.0.0
 */
public class Serialization {

    public static final Gson gson;


    static {
        gson = new GsonBuilder().excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT).setPrettyPrinting().create();
    }

}
