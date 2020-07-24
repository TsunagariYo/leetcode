package IM;

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

    @RequestMapping("/socket")
    public String index(){
        return "hello";
    }
}
