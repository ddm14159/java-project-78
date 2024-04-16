package hexlet.code;

import hexlet.code.schemas.NumberBaseSchema;
import hexlet.code.schemas.StringBaseSchema;

public class Validator {
    public StringBaseSchema string() {
        return new StringBaseSchema();
    }

    public NumberBaseSchema number() {
        return new NumberBaseSchema();
    }
}
