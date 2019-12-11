import java.util.HashMap;

public class test {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Integer integer = map.get(i
            );
            System.out.println(integer);
        }
    }
}
