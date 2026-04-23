package cesde.migaja.migajaApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cesde.migaja.migajaApp.Models.MedioPago;

@Repository
public interface Imediodepagorepositorio extends JpaRepository<MedioPago, Integer> {

}
