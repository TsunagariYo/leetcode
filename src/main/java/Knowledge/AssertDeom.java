package Knowledge;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 *  断言
 *
 */
public class AssertDeom {

    public static void main(String[] args) {
        assert true;
        System.out.println("断言1  成功");
        assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2  成功");
    }
    public class user{
        private String name;
        private String age;
    }

    @Test
    public void testAsser(){
        user user = new user();
        Assert.notNull(user,"用户不存在");
    }


}
