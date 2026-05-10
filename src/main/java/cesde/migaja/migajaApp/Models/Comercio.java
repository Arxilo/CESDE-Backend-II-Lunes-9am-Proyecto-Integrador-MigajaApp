package cesde.migaja.migajaApp.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "comercios")
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name="nit", nullable = false, unique = true)
    private Integer nit;

    @Column(name="nombre_completo", nullable = false, unique = false, length = 50)
    private String nombre;

    @Column(name="correo", nullable = false, unique = false, length = 70)
    private String correo;

    @Column(name="direccion", nullable = false, unique = false, length = 50)
    private String direccion;

    @Column(name="telefono", nullable = false, unique = false, length = 11)
    private String telefono;

    @Column(name="sitio_Web", nullable = true, unique = false, length = 100)
    private String sitioWeb;

    @Column(name="actividad", nullable = false, unique = false, length = 200)
    private String actividad;

    @Column(name="representante_Legal", nullable = false, unique = false , length = 100)
    private String representanteLegal;

    @JsonIgnore
    @OneToMany(mappedBy = "comercio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gasto> gastos;

    public Comercio() {
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public Comercio(Integer id, Integer nit, String nombre, String correo, String direccion, String telefono,
            String sitioWeb, String actividad, String representanteLegal) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sitioWeb = sitioWeb;
        this.actividad = actividad;
        this.representanteLegal = representanteLegal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    

}
