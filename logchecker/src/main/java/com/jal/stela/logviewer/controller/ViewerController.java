package com.jal.stela.logviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by K.Kangai on 2015/07/31.
 */
@Controller
public class ViewerController {

    /**
     * １．引数にModelを取るパターン
     * @return String viewへのPath
     */
    @RequestMapping("hello13")
    public String hello1(Model model) {
        String word = "hello";
        model.addAttribute("word", word + " Pattern 1");
        return "example/greeting";
    }
}
