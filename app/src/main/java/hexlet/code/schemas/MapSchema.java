package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Function;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        Function<Map<?, ?>, Boolean> fn = (v) -> v != null;
        this.addRule("required", fn);

        return this;
    }

    public MapSchema sizeof(Integer size) {
        Function<Map<?, ?>, Boolean> fn = (v) -> v.size() == size;
        this.addRule("sizeof", fn);

        return this;
    }
}
