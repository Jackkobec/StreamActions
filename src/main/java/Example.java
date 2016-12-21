import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        try {
            list = Stream.generate(() ->
                    new Random().nextInt(34))
                    .filter(i -> i % 2 == 0)
                    .limit(7)
                    .distinct()
                    .filter(i -> i > 2)
                    .sorted((i1, i2) -> i2.compareTo(i1))
                    .map(i -> i + 1)
                    .map(ActionsWithArrays::method)
                    //.map(ActionsWithArrays::method)
//                    .map(i -> i ==7 ? -7 : (int) (Math.random() * 7) )
                    .map(i -> {
                        if (i == 7 || (i == 2)) {
                            throw new NullPointerException("7");
                        }
                        return (int) (Math.random() * 7);
                    })
                    .collect(Collectors.toList());

            list.forEach(i -> System.out.print(i + "; "));
        } catch (NullPointerException e) {
            System.out.println("You win!");
        }

        try {
            Integer[] arr = Stream.generate(() ->
                    new Random().nextInt(34))
                    .filter(i -> i % 2 == 0)
                    .limit(7)
                    .distinct()
                    .filter(i -> i > 2)
                    .sorted((i1, i2) -> i2.compareTo(i1))
                    .map(i -> i + 1)
                    .map(ActionsWithArrays::method)
                    //.map(ActionsWithArrays::method)
//                    .map(i -> i ==7 ? -7 : (int) (Math.random() * 7) )
                    .map(i -> {
                        if (i == 7 || (i == 2)) {
                            throw new NullPointerException("7");
                        }
                        return (int) (Math.random() * 7);
                    })
                    .toArray(Integer[]::new);
            Stream.of(arr).forEach(i -> System.out.print(i + "; "));
        } catch (NullPointerException e) {
            System.out.println("You win!");
        }

    }

    public static Integer method(Integer integer) {

        System.out.println("ActionsWithArrays::method: " + integer + "; ");
        return integer;
    }

    public List<Integer> removeEl(List<Integer> list, Integer el) {
        list.removeIf(i -> i.equals(el));
        return list;
    }
}
