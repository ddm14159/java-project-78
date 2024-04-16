package hexlet.code.schemas;

import java.util.function.Function;

public class NumberBaseSchema extends BaseSchema<Integer> {
    public NumberBaseSchema required() {
        Function<Integer, Boolean> fn = (v) -> v != null;
        this.rules.add(fn);

        return this;
    }

    public NumberBaseSchema positive() {
        Function<Integer, Boolean> fn = (v) -> v > 0;
        this.rules.add(fn);

        return this;
    }

    public NumberBaseSchema range(Integer min, Integer max) {
        Function<Integer, Boolean> fn = (v) -> v >= min && v <= max;
        this.rules.add(fn);

        return this;
    }
}
