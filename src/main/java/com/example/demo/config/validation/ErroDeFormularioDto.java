package com.example.demo.config.validation;

public class ErroDeFormularioDto {

    String campo;
    String erro;

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
