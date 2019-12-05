import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("key","value");
        HashMap<Object, Object> map1 = new HashMap<>(map);
        System.out.println(map);
        System.out.println(map1);
    }

}