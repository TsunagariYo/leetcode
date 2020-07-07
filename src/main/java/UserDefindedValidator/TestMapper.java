package UserDefindedValidator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestMapper
 * @Description
 * @Author Administrator
 * @Date 2020/7/7 0007 10:13
 */
@RestController
@RequestMapping("/validator")
public class TestMapper {
    @RequestMapping("test")
    public String test(@Validated @RequestBody Student student, BindingResult result){
        return "请求成功";
    }
}
