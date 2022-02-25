package com.pedrovbo.emprestimolivros.repository;

import com.pedrovbo.emprestimolivros.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
