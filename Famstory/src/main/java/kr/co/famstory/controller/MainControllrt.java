package kr.co.famstory.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllrt {

    @GetMapping(value = {"/", "index"})
    public String index(){
        return "index";
    }
}
