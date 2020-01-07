package Knowledge.Lambda;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Demo
 * @Description
 * @Author Administrator
 * @Date 2020/1/6 0006 10:26
 */
interface IPerson {
    void person();
}

public class Demo {

    public void test(IPerson iPerson) {
        iPerson.person();
    }

    @Test
    public void test() {
        test(() -> System.out.println(1));
    }
}


