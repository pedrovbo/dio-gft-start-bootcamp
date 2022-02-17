package com.pedrovbo.bootcamp.repositories;

import com.pedrovbo.bootcamp.model.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
    // TODO: precisa implementar algo?
}
