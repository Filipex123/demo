package com.example.demo.controller;

import com.example.demo.dto.TopicoDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Topico;
import com.example.demo.repository.TopicoRepository;
import com.sun.javafx.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @GetMapping("/topicos")
    @ResponseBody()
    public List<TopicoDTO> listaTopicos(String nomeCurso){
        List<Topico> lista = (Objects.isNull(nomeCurso))?topicoRepository.findAll():topicoRepository.findByCursoNome(nomeCurso);
        return TopicoDTO.converter(lista);
    }
}
