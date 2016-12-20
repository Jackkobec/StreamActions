import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Jack on 19.12.2016.
 */
public class ActionsWWithElementsInTheCollections<T> {

    private List<Integer> list;
    private Integer el = new Integer(7);

    public ActionsWWithElementsInTheCollections() {
    }


    public List<Integer> removeElements(List<Integer> inputList, Integer el) {

        for (Integer i : inputList) {
            if (i.equals(el)) {
                inputList.remove(i);
            }
        }

        return inputList;
    }



    public static void main(String[] args) {

      //new ActionsWWithElementsInTheCollections().removeElements(new ArrayList<>(), 7);
//        String[] array  = Stream.generate(() -> new String("sf")).limit(7).toArray(String[]::new);
        Integer[] array  = Stream.generate(() -> new Integer(new Random().nextInt(7))).limit(7).sorted().toArray(Integer[]::new);
        System.out.println(Arrays.deepToString(array));
    }
}