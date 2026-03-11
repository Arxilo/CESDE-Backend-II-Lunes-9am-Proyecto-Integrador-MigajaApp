package cesde.migaja.migajaApp.Models;

import java.util.List;

import cesde.migaja.migajaApp.Models.Utils.Rol;
import cesde.migaja.migajaApp.Models.Utils.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_completo" , nullable = false , unique = false , length = 50)
    private String nombre;

    @Column(name = "tipo_documento" , nullable = false , unique = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "numero_documento" , nullable = false , unique = true , length = 15 )
    private String numeroDocumento;
    
    @Column(name = "edad" , nullable = false , unique = false)
    private Integer edad;
    
    @Column(name = "apellidos" , nullable = false , unique = false , length = 50)
    private String apellidos;
    
    @Column(name = "email" , nullable = false , unique = true , length = 50)
    private String email;
    
    @Column(name = "telefono" , nullable = false , unique = true , length = 10)
    private String telefono;
    
    @Column(name = "direccion" , nullable = false , unique = false , length = 100)
    private String direccion;
    
    @Column(name = "rol" , nullable = false , unique = false)
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<MedioPago> mediosDePago;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, TipoDocumento tipoDocumento, String numeroDocumento, Integer edad,
            String apellidos, String email, String telefono, String direccion, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.edad = edad;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
