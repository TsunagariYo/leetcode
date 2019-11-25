package CallbackDemo;

/**
 * 上层服务接口
 */
public interface UpperService {
    public void upperTaskAfterCallBottomService(String upperParam);
    public String callBottomService(final String param);
}
