import java.util.Arrays;

/**
 * Created by Jack on 09.12.2016.
 */
public class NullValidationForVarArgs {

    public boolean checkStringForNullAndEmptyConditionJava8(String... args) {
        //Incorrect
        /*Arrays.stream(args)
               *//*can be map*//*.filter(str -> {
            if (str == null || str.isEmpty()) {
                throw new NullPointerException("Передано Null значение или пустая строка.");
            }
            return true;
        });*/

        /**Correct*/
        if (args == null || args.length == 0) {
            throw new NullPointerException("Передано null значение или args.length == 0.");
        }

        /**Correct*/
        return Arrays.stream(args)
               /*can be map*/.allMatch(str -> {
                    if (str == null || str.isEmpty()) {
                        throw new NullPointerException("Один из параметров имеет null значение или имеется пустая строка.");
                    } else return true;
                });
    }

    /**
     * checkStringForNullAndEmptyConditionJava8Alt
     *
     * @param args
     * @return
     */
    public boolean checkStringForNullAndEmptyConditionJava8Alt(String... args) {

        //Incorrect
        /*Arrays.stream(args)
                .map(str -> (str == null || str.isEmpty()) ? new NullPointerException("Передано Null значение или пустая строка.") : true);*/

        /**Correct*/
        if (args == null || args.length == 0) {
            throw new NullPointerException("Передано null значение или args.length == 0.");
        }

        /**Correct*/
        return Arrays.stream(args)
                .allMatch(str -> (str == null || str.isEmpty()) ? false : true);

    }
}
