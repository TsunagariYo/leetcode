import java.util.Date;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("test",5);
        Integer integer = map.get("test");
        System.out.println(integer);
    }
}
