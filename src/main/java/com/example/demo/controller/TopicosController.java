package com.example.demo.controller;

import com.example.demo.controller.form.TopicoForm;
import com.example.demo.dto.DetalhamentoTopicoDTO;
import com.example.demo.dto.TopicoDTO;
import com.example.demo.model.Topico;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping()
    @Cacheable(value = "listaTopicos")
    public Page<TopicoDTO> listaTopicos(@RequestParam(required = false) String nomeCurso,
                @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao) {

        Page<Topico> pg = (Objects.isNull(nomeCurso))?topicoRepository.findAll(paginacao):topicoRepository.findByCursoNome(nomeCurso, paginacao);
        return TopicoDTO.converter(pg);
    }

    @PostMapping()
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoTopicoDTO> detalhar (@PathVariable("id") Long codigo) {
        Optional<Topico> optional = topicoRepository.findById(codigo);
        if(optional.isPresent()) {
            Topico resultado = topicoRepository.getOne(codigo);
            return ResponseEntity.ok(new DetalhamentoTopicoDTO(resultado));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar (@PathVariable("id") Long codigo, @RequestBody @Valid AtualizaTopicoDTO form) {
        Optional<Topico> optional = topicoRepository.findById(codigo);
        if(optional.isPresent()) {
            Topico topico = form.atualizar(codigo,topicoRepository);
            return ResponseEntity.ok(new TopicoDTO(topico));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable("id") Long codigo) {
        Optional<Topico> optional = topicoRepository.findById(codigo);
        if(optional.isPresent()) {
            topicoRepository.deleteById(codigo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}

