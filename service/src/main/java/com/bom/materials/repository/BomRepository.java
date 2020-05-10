package com.bom.materials.repository;

import com.bom.materials.model.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BomRepository extends JpaRepository<Bom, Long> {

    Optional<List<Bom>> findByEnvironment(String environment);

    Optional<Bom> findByServiceNameAndEnvironment(String serviceName, String environment);

}
