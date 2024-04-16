package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class BaseSchema<T> {
    List<Function<T, Boolean>> rules = new ArrayList<>();

    public boolean isValid(T value) {
        for (Function<T, Boolean> fn: rules) {
            if (!fn.apply(value)) {
                return false;
            }
        }

        return true;
    }
}
