package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class BaseSchema<T> {
    private final Map<String, Function<T, Boolean>> rules = new HashMap<>();

    public final boolean isValid(T value) {
        for (Function<T, Boolean> fn: rules.values()) {
            if (!fn.apply(value)) {
                return false;
            }
        }

        return true;
    }

    public final void addRule(String name, Function<T, Boolean> func) {
        this.rules.put(name, func);
    }
}
