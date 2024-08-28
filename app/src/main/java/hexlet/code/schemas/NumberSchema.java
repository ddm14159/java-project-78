package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Function;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        Function<Integer, Boolean> fn = Objects::nonNull;
        this.addRule("required", fn);

        return this;
    }

    public NumberSchema positive() {
        Function<Integer, Boolean> fn = (v) -> v == null || v > 0;
        this.addRule("positive", fn);

        return this;
    }

    public NumberSchema range(Integer min, Integer max) {
        Function<Integer, Boolean> fn = (v) -> v >= min && v <= max;
        this.addRule("range", fn);

        return this;
    }
}
