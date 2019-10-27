package com.example.demo.repository;

import com.example.demo.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    List<Topico> findByCursoNome(String nomeCurso);
}
