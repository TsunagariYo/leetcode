package Knowledge.CallbackDemo;

import java.util.Date;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        BottomService bottomService = new BottomService();

        UpperService upperService = new UpperServiceImpl(bottomService);

        System.out.println("=============== callBottomService start ==================:" + new Date());

        String result = upperService.callBottomService("callBottomService start -->");

        upperService.upperTaskAfterCallBottomService(result);
        //upperTaskAfterCallBottomService执行必须等待callBottomService()调用BottomService.bottom()方法返回后才能够执行
        System.out.println("=============== callBottomService end ====================:" + new Date());
    }

}
