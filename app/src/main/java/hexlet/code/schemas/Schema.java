package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class Schema {
    List<Function<String, Boolean>> rules = new ArrayList<>();

    public boolean isValid(String str) {
        for (Function<String, Boolean> fn: rules) {
            if (!fn.apply(str)) {
                return false;
            }
        }

        return true;
    }
}
