import lombok.experimental.UtilityClass;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

@UtilityClass
public class CheckSchemajson {

    private final JSONObject jsonSchema = new JSONObject(
            new JSONTokener(CheckSchemajson.class.getResourceAsStream("/schema-project.json")));

    public void check(String json) {
        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(new JSONObject(json));
    }
}
