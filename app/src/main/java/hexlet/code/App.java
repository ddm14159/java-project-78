package hexlet.code;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        System.out.println("ddd");
        var v = new Validator();

        var sch = v.map();
        var map = Map.of(1, 2, 3, 4);
        var res = sch.sizeof(3).isValid(map);

        System.out.println(res);
    }
}
