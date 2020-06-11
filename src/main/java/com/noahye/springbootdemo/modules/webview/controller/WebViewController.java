package com.noahye.springbootdemo.modules.webview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WebViewController {

    @RequestMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return "index";
    }
}
