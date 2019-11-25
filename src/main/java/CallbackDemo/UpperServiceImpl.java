package CallbackDemo;

/**
 * 上层接口实现类
 */
public class UpperServiceImpl implements UpperService{

    private BottomService bottomService = new BottomService();
    @Override
    public void upperTaskAfterCallBottomService(String upperParam) {
        System.out.println(upperParam + " upperTaskAfterCallBottomService.execute");
    }

    public UpperServiceImpl(BottomService bottomService) {
        this.bottomService = bottomService;
    }

    @Override
    public String callBottomService(final String param) {
        return bottomService.bottom(param + "callBottomService.bottom() execute -->" );
    }
}
