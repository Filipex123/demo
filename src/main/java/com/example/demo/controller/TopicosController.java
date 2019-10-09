package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.model.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TopicosController {

    @GetMapping("/topicos")
    @ResponseBody()
    public List<Topico> listaTopicos(){
        Topico topico = new Topico("Duvidas","tire aqui suas duvidas", new Curso("Spring","programacao"));
        return Arrays.asList(topico);
    }
}
