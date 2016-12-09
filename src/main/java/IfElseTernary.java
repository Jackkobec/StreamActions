import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Jack on 09.12.2016.
 */
public class IfElseTernary {

    public static boolean checkWithTernary(Map<String, Object> map, String string) {

        //map.keySet().stream().allMatch(s -> s.contains(string) ? true : false);

        return map.keySet().stream().anyMatch(s -> s.contains(string));
    }

    public static boolean checkWithIfElse(Map<String, Object> map, String string) {

        return map.keySet().stream().anyMatch(s -> {
            if (s.contains(string)) {
                return true;
            } else return false;
        });
    }


    public static void main(String[] args) {

        IfElseTernary ifElseTernary = new IfElseTernary();

        String str = "Vasa";
        Map<String, Object> map = new HashMap<>();

        map.put(str, new Object());

        //System.out.println(checkWithIfElse(map, "sdf"));
        System.out.println(ifElseTernary.checkWithIfElse(null, null));

    }
}
