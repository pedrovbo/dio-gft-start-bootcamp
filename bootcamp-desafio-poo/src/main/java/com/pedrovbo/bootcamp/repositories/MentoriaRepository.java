package com.pedrovbo.bootcamp.repositories;

import com.pedrovbo.bootcamp.model.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoriaRepository extends JpaRepository<Mentoria, Long> {
    //TODO: Precisa implementar algo?
}
