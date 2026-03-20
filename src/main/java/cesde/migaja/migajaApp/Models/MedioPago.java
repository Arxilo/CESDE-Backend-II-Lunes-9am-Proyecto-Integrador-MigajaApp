package cesde.migaja.migajaApp.Models;

import cesde.migaja.migajaApp.Models.Utils.Franquicia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medios_pago")
public class MedioPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_franquicia" , nullable = false , unique = false , length = 50)
    private String nombre;

    @Column(name = "franquicia" , nullable = false , unique = false)
    @Enumerated(EnumType.STRING)
    private Franquicia franquicia;

    @Column(name = "estado" , nullable = false , unique = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "fk_usuario" , referencedColumnName = "id")
    private Usuario usuario;

    public MedioPago() {}

    public MedioPago(Integer id, String nombre, Franquicia franquicia, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    

    

}
