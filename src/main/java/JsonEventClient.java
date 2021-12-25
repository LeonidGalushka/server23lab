import lombok.Data;

import java.util.Objects;

@Data
public class JsonEventClient implements Comparable<JsonEventClient> {
    private String id;
    private String event;
    private String v_0;

    @Override
    public int compareTo(JsonEventClient o) {
        return this.getId().equals(o.getId()) ? 0 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonEventClient that = (JsonEventClient) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
