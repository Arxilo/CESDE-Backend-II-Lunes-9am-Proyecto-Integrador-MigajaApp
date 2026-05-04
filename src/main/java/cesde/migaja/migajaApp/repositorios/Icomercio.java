package cesde.migaja.migajaApp.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cesde.migaja.migajaApp.Models.Comercio;


@Repository
public interface Icomercio extends JpaRepository<Comercio, Integer> {

}
