package SpringBoot;

import SpringBoot.domain.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/demo")
public class test {
    @RequestMapping(value = "/ll", method = {RequestMethod.POST, RequestMethod.GET})
    public void demo(User user){
        System.out.println(user);
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));// CustomDateEditor为自定义日期编辑器

        for (int i = 0; i < 10; i++) {

        }
    }
}
