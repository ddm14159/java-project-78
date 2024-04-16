package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("ddd");
        var v = new Validator();

        var sch = v.string();
        var res = sch.required().minLength(5).contains("dd").isValid("acdd");

        System.out.println(res);
    }
}
