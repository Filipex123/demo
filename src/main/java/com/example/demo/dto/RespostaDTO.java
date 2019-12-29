package com.example.demo.dto;

import com.example.demo.model.Resposta;
import java.time.LocalDateTime;

public class RespostaDTO {

    private Long id;
    private String mensagem;
    private String nomeAutor;
    private LocalDateTime dataCriacao ;

    public RespostaDTO(Resposta resposta) {
        this.id =  resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.nomeAutor = resposta.getAutor().getNome();
        this.dataCriacao = resposta.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
