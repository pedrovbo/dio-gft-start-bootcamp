package com.pedrovbo.bootcamp.repositories;

import com.pedrovbo.bootcamp.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // TODO: Precisa implementar algo?

}
