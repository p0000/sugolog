package com.jal.stela.example.controller;

import com.jal.stela.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kei.Kangai on 2015/07/06.
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService ;

    /**
     * １．引数にModelを取るパターン
     * @return String viewへのPath
     */
    @RequestMapping("hello1")
    public String hello1(Model model) {
        String word = helloService.saySomething();
        model.addAttribute("word", word + " Pattern 1");
        return "example/greeting";
    }

    /**
     * 2.ModelAndViewを返すパターン
     * @return ModelAndView
     */
    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public ModelAndView hello2() {
        ModelAndView mav = new ModelAndView("example/greeting");
        String word = helloService.saySomething();
        mav.addObject("word", word + " Pattern 2");
        return mav;
    }
}
