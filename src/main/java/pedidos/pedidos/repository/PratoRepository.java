package pedidos.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedidos.pedidos.model.Prato;

import java.util.Optional;

public interface PratoRepository extends JpaRepository<Prato, Long>{
    Optional<Prato> findByNome(String name);
}
