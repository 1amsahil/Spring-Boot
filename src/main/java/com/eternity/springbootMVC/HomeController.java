package com.eternity.springbootMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home()
    {
        return"index.jsp";
    }

    @RequestMapping("addUser")
    public ModelAndView addUser(@RequestParam("uid") int uid, @RequestParam("uname") String uname, ModelAndView mv)  // HttpServletRequest req, HttpSession session
    {
        User user = new User();
        user.setUid(uid);
        user.setUname(uname);

        mv.addObject("user",user);
        mv.setViewName("result.jsp");
        return mv;
    }
}
