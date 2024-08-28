package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void testCheckStringRequired() {
        var v = new Validator();
        var scheme = v.string();

        assertThat(scheme.isValid("test")).isTrue();
        assertThat(scheme.required().isValid("test")).isTrue();
        assertThat(scheme.required().isValid("")).isFalse();
        assertThat(scheme.required().isValid(null)).isFalse();
    }

    @Test
    public void testCheckStringMinLength() {
        var v = new Validator();
        var scheme = v.string();

        assertThat(scheme.minLength(3).isValid(null)).isTrue();
        assertThat(scheme.minLength(3).isValid("test")).isTrue();
        assertThat(scheme.minLength(5).isValid("test")).isFalse();
    }

    @Test
    public void testCheckStringContains() {
        var v = new Validator();
        var scheme = v.string();

        assertThat(scheme.contains("es").isValid("test")).isTrue();
        assertThat(scheme.contains("se").isValid("test")).isFalse();
    }

    @Test
    public void testCheckNumberRequired() {
        var v = new Validator();
        var scheme = v.number();

        assertThat(scheme.isValid(10)).isTrue();
        assertThat(scheme.required().isValid(10)).isTrue();
        assertThat(scheme.required().isValid(null)).isFalse();
    }

    @Test
    public void testCheckNumberPositive() {
        var v = new Validator();
        var scheme = v.number();

        assertThat(scheme.isValid(null)).isTrue();
        assertThat(scheme.positive().isValid(10)).isTrue();
        assertThat(scheme.positive().isValid(-10)).isFalse();
    }

    @Test
    public void testCheckNumberRange() {
        var v = new Validator();
        var scheme = v.number();

        assertThat(scheme.range(5, 15).isValid(10)).isTrue();
        assertThat(scheme.range(10, 15).isValid(16)).isFalse();
        assertThat(scheme.range(10, 15).isValid(10)).isTrue();
    }

    @Test
    public void testCheckMapRequired() {
        var v = new Validator();
        var scheme = v.map();

        assertThat(scheme.required().isValid(null)).isFalse();
        assertThat(scheme.required().isValid(new HashMap<>())).isTrue();
        assertThat(scheme.required().isValid(Map.of(1, 2, 3, 4))).isTrue();
    }

    @Test
    public void testCheckMapSizeof() {
        var v = new Validator();
        var scheme = v.map();

        assertThat(scheme.sizeof(0).isValid(new HashMap<>())).isTrue();
        assertThat(scheme.sizeof(2).isValid(Map.of(1, 2, 3, 4))).isTrue();
        assertThat(scheme.sizeof(3).isValid(Map.of(1, 2, 3, 4))).isFalse();
    }

    @Test
    public void testCheckMapShape() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas1 = new HashMap<>();
        schemas1.put("firstName", v.string().required());
        schemas1.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas1);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");

        assertThat(schema.isValid(human1)).isTrue();

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertThat(schema.isValid(human2)).isFalse();

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertThat(schema.isValid(human3)).isFalse();
    }
}
