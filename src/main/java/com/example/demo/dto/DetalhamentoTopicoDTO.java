package com.example.demo.dto;

import com.example.demo.model.Resposta;
import com.example.demo.model.StatusTopico;
import com.example.demo.model.Topico;
import com.example.demo.model.Usuario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhamentoTopicoDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private StatusTopico status;
    private String autor;
    private List<RespostaDTO> resposta;

    public DetalhamentoTopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = status;
        this.autor = topico.getAutor().getNome();
        this.resposta = new ArrayList<>();
        this.resposta = topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public List<RespostaDTO> getResposta() {
        return resposta;
    }
}
