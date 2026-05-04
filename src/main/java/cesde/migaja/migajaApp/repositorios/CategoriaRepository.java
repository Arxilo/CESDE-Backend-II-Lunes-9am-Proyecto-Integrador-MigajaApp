package cesde.migaja.migajaApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cesde.migaja.migajaApp.Models.categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<categoria, Integer> {

}