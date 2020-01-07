/**
 * @ClassName test
 * @Description
 * @Author Administrator
 * @Date 2019/12/30 0030 10:47
 */
public class test {
    public static int ReturnAndFinally(){
        int i = 10;
        try {
           return i += 3;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            i += 10;
        }
        return 10;
    }

    public static void main(String[] args) {
        System.out.println( ReturnAndFinally());
    }
}
