package com.example.demo.controller;

import com.example.demo.model.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TopicosController {

    @GetMapping("/topicos")
    @ResponseBody()
    public List<Topico> sayHello(){
        return new ArrayList<>();
    }
}
