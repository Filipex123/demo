package com.example.demo.repository;

import com.example.demo.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
}
