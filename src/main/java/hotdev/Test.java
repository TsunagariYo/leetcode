package hotdev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Test
 * @Description
 * @Author Administrator
 * @Date 2020/7/17 0017 15:06
 */
@RestController
@RequestMapping("/hotdev")
public class Test {
    @GetMapping("test")
    public String Test(){
        return "222";
    }
}
