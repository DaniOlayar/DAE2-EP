package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {}
