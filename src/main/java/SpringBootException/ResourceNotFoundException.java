package SpringBootException;

import java.util.Map;

/**
 * @ClassName ResourceNotFoundException
 * @Description
 * @Author Administrator
 * @Date 2020/6/3 0003 17:27
 */
public class ResourceNotFoundException extends BaseException{
    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}
