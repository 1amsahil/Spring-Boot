package com.eternity.springbootMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String home()
    {
        return"index.jsp";
    }

    @RequestMapping("addUser")
    public String addUser(@ModelAttribute("newuser") User user)  //ModelAttribute is optional when your object name is same
    // HttpServletRequest req, HttpSession session
    {
        return "result.jsp";
    }

    @ModelAttribute("course")
    public String courseName()
    {
        return "java";
    }
}
