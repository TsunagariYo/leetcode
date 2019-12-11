package UtileS.DatetoFormat;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("Test")
public class Test {

   /* @InitBinder
    protected void dateTypeConverter(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new UtilDateEditor());
    }*/

    @RequestMapping(value = "date",method = RequestMethod.GET)
    @ResponseBody
    public String  test(@RequestBody Student student){
        System.out.println(student.toString());
        return "200";
    }
}
