import java.util.*;

/**
 * Created by Jack on 20.12.2016.
 */
public class Example {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Vasa");
        map.put(2, "Peta");
        map.put(3, "Kola");

        map.forEach((k, v) -> System.out.println(k + "=" + v));

        int el = 7;
        List<Integer> list = new ArrayList<>();

//        list = Stream.generate(() ->
//                new Integer(new Random().nextInt(34)))
//                .limit(7)
//                .filter(i -> i % 2 == 0)
//                .map(i -> System.out.println(i)


    }

    public static Integer method(Integer integer) {

        return integer;
    }

    public List<Integer> removeEl(List<Integer> list, Integer el) {
        list.removeIf(i -> i.equals(el));
        return list;
    }
}
