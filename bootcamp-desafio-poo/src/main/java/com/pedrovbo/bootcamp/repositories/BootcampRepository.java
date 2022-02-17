package com.pedrovbo.bootcamp.repositories;

import com.pedrovbo.bootcamp.model.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Long> {


    boolean existsByNome(String nome);

}
