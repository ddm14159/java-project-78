package hexlet.code;

import org.junit.jupiter.api.Test;
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
}
