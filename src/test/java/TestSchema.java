import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

public class TestSchema {
    @Test
    public void testSchemaValidate() throws ValidationException {
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(TestSchema.class.getResourceAsStream("/schema.json")));

        String jsonString = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Lampshade\",\n" +
                "    \"price\": 1\n" +
                "}";

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(new JSONObject(jsonString));

       // Schema schema = SchemaLoader.load(jsonSchema);
        //schema.validate(jsonSubject);
    }
}
