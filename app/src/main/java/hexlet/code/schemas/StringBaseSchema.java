package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Function;

public class StringBaseSchema extends BaseSchema<String> {
    public StringBaseSchema required() {
        Function<String, Boolean> fn = (v) -> v != null && !Objects.equals(v, "");
        this.rules.add(fn);

        return this;
    }

    public StringBaseSchema minLength(Integer length) {
        Function<String, Boolean> fn = (v) -> v.length() >= length;
        this.rules.add(fn);

        return this;
    }

    public StringBaseSchema contains(String substr) {
        Function<String, Boolean> fn = (v) -> v.contains(substr);
        this.rules.add(fn);

        return this;
    }
}
