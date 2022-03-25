package task_5.task_json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.json.JSONObject;

import java.io.IOException;

public abstract class JSONModel<T> {

    static ObjectMapper mapper;

    ObjectMapper getObjectMapper() {
        if (mapper == null) {
            mapper = initMapper();
        }
        return mapper;
    }

    private ObjectMapper initMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        return mapper;
    }

    public JSONObject asJson() {
        try {
            return new JSONObject(getObjectMapper().writeValueAsString(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public static <T> T makeMyFromJsonString(Class<T> currentClass, String jsonObjectString) {
        try {
            return mapper.readValue(jsonObjectString, currentClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
