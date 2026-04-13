package cesde.migaja.migajaApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cesde.migaja.migajaApp.Models.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario , Integer>{


    
    

}
