package cesde.migaja.migajaApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cesde.migaja.migajaApp.Models.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {

}
