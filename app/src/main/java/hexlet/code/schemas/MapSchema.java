package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        Function<Map<?, ?>, Boolean> fn = Objects::nonNull;
        this.addRule("required", fn);

        return this;
    }

    public MapSchema sizeof(Integer size) {
        Function<Map<?, ?>, Boolean> fn = (v) -> v.size() == size;
        this.addRule("sizeof", fn);

        return this;
    }

    public MapSchema shape(Map<?, ? extends BaseSchema> schemas) {
        Function<Map<?, ?>, Boolean> fn = (v) -> {
            for (var item: v.entrySet()) {
                var field = item.getKey();
                var value = item.getValue();

                if (!schemas.get(field).isValid(value)) {
                    return false;
                }
            }
            return true;
        };

        this.addRule("shape", fn);

        return this;
    }
}
