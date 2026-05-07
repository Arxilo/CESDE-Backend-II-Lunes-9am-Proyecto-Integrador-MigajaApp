package cesde.migaja.migajaApp.configuracion;

import cesde.migaja.migajaApp.Models.Categoria;
import cesde.migaja.migajaApp.Models.utils.Estado;
import cesde.migaja.migajaApp.Models.utils.Prioridad;
import cesde.migaja.migajaApp.repositorios.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Order(2)
public class CargarDatosCategoria implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    public CargarDatosCategoria(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... argumentos) {
        String[] nombres = {"Alimentación", "Transporte", "Vivienda", "Salud", "Educación", "Entretenimiento", "Ropa", "Ahorro", "Regalos", "Mascotas"};
        String[] responsables = {"Admin", "Mateo", "Valentina", "Sistema"};
        String[] colores = {"#FF5733", "#33FF57", "#3357FF", "#F333FF", "#FF33A1", "#33FFF3", "#F3FF33", "#FFA133", "#9933FF", "#33FF99"};
        String[] iconos = {"restaurant", "directions_car", "home", "medical_services", "school", "theater_comedy", "checkroom", "savings", "redeem", "pets"};
        
        Prioridad[] prioridades = Prioridad.values();
        Estado[] estados = Estado.values();
        
        Random aleatorio = new Random(42);
        List<Categoria> listaCategorias = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String nombre = nombres[aleatorio.nextInt(nombres.length)];
            LocalDate fechaCreacion = LocalDate.now().minusDays(aleatorio.nextInt(365));
            String responsable = responsables[aleatorio.nextInt(responsables.length)];
            String justificacion = "Carga inicial de datos para la categoría " + nombre;
            String descripcion = "Descripción detallada para el manejo de " + nombre.toLowerCase();
            Prioridad prioridad = prioridades[aleatorio.nextInt(prioridades.length)];
            String color = colores[aleatorio.nextInt(colores.length)];
            String icono = iconos[aleatorio.nextInt(iconos.length)];
            Estado estado = estados[aleatorio.nextInt(estados.length)];

            listaCategorias.add(new Categoria(
                nombre, 
                fechaCreacion, 
                responsable, 
                justificacion, 
                descripcion, 
                prioridad, 
                color, 
                icono, 
                estado
            ));
        }

        categoriaRepository.saveAll(listaCategorias);
    }
}