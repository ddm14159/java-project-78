package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Function;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Function<String, Boolean> fn = (v) -> v != null && !Objects.equals(v, "");
        this.addRule("required", fn);

        return this;
    }

    public StringSchema minLength(Integer length) {
        Function<String, Boolean> fn = (v) -> v.length() >= length;
        this.addRule("minlength", fn);

        return this;
    }

    public StringSchema contains(String substr) {
        Function<String, Boolean> fn = (v) -> v.contains(substr);
        this.addRule("contains", fn);

        return this;
    }
}
