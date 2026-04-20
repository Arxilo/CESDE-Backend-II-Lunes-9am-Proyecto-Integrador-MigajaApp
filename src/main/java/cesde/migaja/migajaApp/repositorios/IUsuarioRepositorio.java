package cesde.migaja.migajaApp.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cesde.migaja.migajaApp.Models.Usuario;
import cesde.migaja.migajaApp.Models.utils.TipoDocumento;


@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario , Integer>{


    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByTipoDocumento(TipoDocumento tipoDocumento);

    Optional<Usuario> findByDocumento(String documento);

    List<Usuario> findByEdad(Integer edad);










    

}
