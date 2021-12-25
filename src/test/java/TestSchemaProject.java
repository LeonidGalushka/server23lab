import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

public class TestSchemaProject {

    //ok
    @Test
    public void testSchemaValidate() throws ValidationException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(TestSchema.class.getResourceAsStream("/schema-project.json")));

        String jsonString = "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"event\": \"UP\",\n" +
                "  \"v_0\": \"20\"\n" +
                "}";

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(new JSONObject(jsonString));
    }

    // no ok, id = 4
    @Test
    public void testSchemaValidate1() throws ValidationException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(TestSchema.class.getResourceAsStream("/schema-project.json")));

        String jsonString = "{\n" +
                "  \"id\": \"4\",\n" +
                "  \"event\": \"UP\",\n" +
                "  \"v_0\": \"20\"\n" +
                "}";

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(new JSONObject(jsonString));
    }

}
