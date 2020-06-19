package ThemLeaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @ClassName WebController
 * @Description
 * @Author Administrator
 * @Date 2020/6/4 0004 9:40
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @GetMapping
    public String index(Model model){

        HashMap<Object, Object> map = new HashMap<>();
        model.addAttribute("map",map);
        map.put("hello","world");
        map.put("hello1","world1");
        map.put("hello2","world2");
        return "hello";
    }
}
