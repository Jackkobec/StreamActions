import sun.plugin2.util.NativeLibLoader;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jack on 20.12.2016.
 */
public class ActionsWithArrays<T> {

    public static void main(String[] args) {
//        System.out.println("Создать и заполнить массив/create and fill array:");
//        String[] array = Stream.generate(() -> new String("sf")).limit(7).toArray(String[]::new);
//
//        System.out.println(new ActionsWithArrays().generatesIntegerArrayWithRandomElements(7, 7));
        try {
            Integer[] arr = Stream.generate(() -> new Integer(new Random().nextInt(34)))
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


    /**
     * Correct work
     *
     * @param randomBorder
     * @param elementsCount
     * @return
     */
    public List<Integer> generatesIntegerArrayWithRandomElements(final Integer randomBorder, final Integer elementsCount) {

        return Stream.generate(() -> new Integer(new Random().nextInt(randomBorder)))
                .limit(elementsCount)
                .collect(Collectors.toList());
    }

    /**
     * Correct work
     *
     * @param randomBorder
     * @param elementsCount
     * @return
     */
    public Integer[] generatesIntegerArrayWithRandomElements2(final Integer randomBorder, final Integer elementsCount) {

        return Stream.generate(() -> new Integer(new Random().nextInt(randomBorder))).
                limit(elementsCount).sorted().
                toArray(Integer[]::new);
    }


    /**
     * Incorrect work
     * Создает, но все элементы Object в непонятном виде.
     * out:[java.lang.Object@7ba4f24f, java.lang.Object@3b9a45b3, java.lang.Object@7699a589,
     * java.lang.Object@58372a00, java.lang.Object@4dd8dc3, java.lang.Object@6d03e736, java.lang.Object@568db2f2]
     *
     * @param object
     * @param count
     * @return
     */
    public Object[] generateRandomObjectArray(Object object, Integer count) {

        return Stream.generate(() -> new Object()).limit(7).toArray(Object[]::new);
    }

    /**
     * Incorrect work
     * Создает, но все элементы Object в непонятном виде.
     * out:[java.lang.Object@7ba4f24f, java.lang.Object@3b9a45b3, java.lang.Object@7699a589,
     * java.lang.Object@58372a00, java.lang.Object@4dd8dc3, java.lang.Object@6d03e736, java.lang.Object@568db2f2]
     *
     * @param object
     * @param count
     * @return
     */
    public Object[] generateRandomObjectArray2(Object object, Integer count) {

//        Object[] array = new Object[count];
//        array = Arrays.stream(array).map(a -> new Object()).toArray();
//        return array;
        Object[] array = new Object[count];
        return Arrays.stream(array).map(a -> new Object()).toArray();

    }

    /**
     * Incorrect work
     * Создает, но все элементы Object в непонятном виде.
     * out:[java.lang.Object@7ba4f24f, java.lang.Object@3b9a45b3, java.lang.Object@7699a589,
     * java.lang.Object@58372a00, java.lang.Object@4dd8dc3, java.lang.Object@6d03e736, java.lang.Object@568db2f2]
     *
     * @param type
     * @param count
     * @return
     */
    public T[] generateRandomTArray(T type, Integer count) {

        T[] array = (T[]) new Object[count];
        array = (T[]) Arrays.stream(array).map(a -> new Object()).toArray();
        return array;
    }

}
