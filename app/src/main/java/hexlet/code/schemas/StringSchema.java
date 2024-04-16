package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Function;

public class StringSchema extends Schema {
    public StringSchema required() {
        Function<String, Boolean> fn = (v) -> v != null && !Objects.equals(v, "");
        this.rules.add(fn);

        return this;
    }

    public StringSchema minLength(Integer length) {
        Function<String, Boolean> fn = (v) -> v.length() >= length;
        this.rules.add(fn);

        return this;
    }

    public StringSchema contains(String substr) {
        Function<String, Boolean> fn = (v) -> v.contains(substr);
        this.rules.add(fn);

        return this;
    }
}
