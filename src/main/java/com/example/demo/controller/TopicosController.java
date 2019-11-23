package com.example.demo.controller;

import com.example.demo.controller.form.TopicoForm;
import com.example.demo.dto.TopicoDTO;
import com.example.demo.model.Topico;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping()
    public List<TopicoDTO> listaTopicos(String nomeCurso){
        List<Topico> lista = (Objects.isNull(nomeCurso))?topicoRepository.findAll():topicoRepository.findByCursoNome(nomeCurso);
        return TopicoDTO.converter(lista);
    }

    @PostMapping()
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){
    Topico topico = form.converter(cursoRepository);
    topicoRepository.save(topico);

    URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }
}
