package com.pedrovbo.bootcamp.repositories;

import com.pedrovbo.bootcamp.model.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends JpaRepository<Dev, Long> {
    //TODO: Precisa implementar algo?
}
