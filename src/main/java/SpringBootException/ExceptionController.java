package SpringBootException;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExceptionController
 * @Description
 * @Author Administrator
 * @Date 2020/6/3 0003 17:42
 */
@RestController
@RequestMapping("/api")
public class ExceptionController {
    @GetMapping("/resourceNotFound")
    public void throwException() {
        Person p=new Person(1L,"SnailClimb");
        throw new ResourceNotFoundException(ImmutableMap.of("person id:", p.getId()));
    }
}
