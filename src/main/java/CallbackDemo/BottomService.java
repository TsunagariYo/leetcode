package CallbackDemo;

/**
 * 底层服务类
 */
public class BottomService {
    public String bottom(String param){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return param + " BottomService.bottom() execute  -- >";

    }

}
