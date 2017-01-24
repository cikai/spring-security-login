package cn.jsutils.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
  public ModelAndView welcomePage() {
    ModelAndView model = new ModelAndView();
    model.setViewName("index");
    return model;
  }

  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public ModelAndView adminPage() {
    ModelAndView model = new ModelAndView();
    model.setViewName("admin");
    return model;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout) {
    ModelAndView model = new ModelAndView();
    if (error != null) {
      model.addObject("error", "用户名或密码错误！");
    }
    if (logout != null) {
      model.addObject("msg", "您已成功退出！");
    }
    model.setViewName("login");
    return model;
  }
}
