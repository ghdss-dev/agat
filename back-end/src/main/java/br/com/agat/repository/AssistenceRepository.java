package br.com.agat.repository;

import br.com.agat.model.Assistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistenceRepository extends JpaRepository<Assistence, Integer> {
}
