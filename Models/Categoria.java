@Entity
Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String FechaCreacion;
    private String responsable;
    private String justificacion;
    private String descripcion;
    private Integer prioridad;
    private String color;
    private String icono;
    private Boolean estado;

    //Constructor CRUD
    public Categoria() {
    }

    //Constructor lleno
    public Categoria(Integer id, String nombre, String fechaCreacion,
        String responsable, String justificacion, String descripcion,
        Integer prioridad, String color, String icono, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.FechaCreacion = fechaCreacion;
        this.responsable = responsable;
        this.justificacion = justificacion;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.color = color;
        this.icono = icono;
        this.estado = estado;
    }

    //Getter y setters
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
    public String getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.FechaCreacion = fechaCreacion;
    }
    public String getJustificacion() {
        return justificacion;
    }
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getIcono() {
        return icono;
    }
    public void setIcono(String icono) {
        this.icono = icono;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    

  
}