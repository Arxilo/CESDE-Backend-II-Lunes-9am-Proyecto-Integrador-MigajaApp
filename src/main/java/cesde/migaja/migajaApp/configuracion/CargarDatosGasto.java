package cesde.migaja.migajaApp.configuracion;

import cesde.migaja.migajaApp.Models.Categoria;
import cesde.migaja.migajaApp.Models.Comercio;
import cesde.migaja.migajaApp.Models.Gasto;
import cesde.migaja.migajaApp.Models.MedioPago;
import cesde.migaja.migajaApp.Models.Usuario;
import cesde.migaja.migajaApp.repositorios.CategoriaRepository;
import cesde.migaja.migajaApp.repositorios.GastoRepository;
import cesde.migaja.migajaApp.repositorios.IUsuarioRepositorio;
import cesde.migaja.migajaApp.repositorios.Icomercio;
import cesde.migaja.migajaApp.repositorios.Imediodepagorepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Order(4)
public class CargarDatosGasto implements CommandLineRunner {

    private final GastoRepository gastoRepositorio;
    private final IUsuarioRepositorio usuarioRepositorio;
    private final CategoriaRepository categoriaRepositorio;
    private final Icomercio comercioRepositorio;
    private final Imediodepagorepositorio medioPagoRepositorio;

    public CargarDatosGasto(GastoRepository gastoRepositorio,
                            IUsuarioRepositorio usuarioRepositorio,
                            CategoriaRepository categoriaRepositorio,
                            Icomercio comercioRepositorio,
                            Imediodepagorepositorio medioPagoRepositorio) {
        this.gastoRepositorio = gastoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
        this.comercioRepositorio = comercioRepositorio;
        this.medioPagoRepositorio = medioPagoRepositorio;
    }

    @Override
    public void run(String... argumentos) {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Categoria> categorias = categoriaRepositorio.findAll();
        List<Comercio> comercios = comercioRepositorio.findAll();
        List<MedioPago> mediosPago = medioPagoRepositorio.findAll();

        if (usuarios.isEmpty() || categorias.isEmpty() || comercios.isEmpty() || mediosPago.isEmpty()) {
            System.out.println("Faltan datos previos (usuarios, categorias, comercios o medios de pago). No se cargan gastos.");
            return;
        }

        String[] descripciones = {
                "Compra de mercado", "Pago de transporte", "Almuerzo", "Cena en restaurante",
                "Compra de medicamentos", "Pago de servicios", "Recarga celular", "Suscripción mensual",
                "Compra de ropa", "Salida de ocio", "Compra de libros", "Mantenimiento de vehículo"
        };
        String[] monedas = {"COP", "USD", "EUR"};
        String[] tiposGasto = {"FIJO", "VARIABLE", "OCASIONAL", "EMERGENCIA"};
        String[] lugares = {"Medellín", "Bogotá", "Cali", "Barranquilla", "Cartagena", "Pereira"};

        Random aleatorio = new Random(42);
        List<Gasto> listaGastos = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            String descripcion = descripciones[aleatorio.nextInt(descripciones.length)];
            LocalDate fecha = LocalDate.now().minusDays(aleatorio.nextInt(365));
            Double monto = 1000.0 + (aleatorio.nextDouble() * 999000.0);
            String imagen = "gasto_" + i + ".png";
            String moneda = monedas[aleatorio.nextInt(monedas.length)];
            String lugar = lugares[aleatorio.nextInt(lugares.length)];
            Boolean esRecurrente = aleatorio.nextBoolean();
            String tipoGasto = tiposGasto[aleatorio.nextInt(tiposGasto.length)];
            Integer impactoFinanciero = 1 + aleatorio.nextInt(10);
            Boolean activo = aleatorio.nextBoolean();
            String observaciones = "Observación generada automáticamente para el gasto " + i;

            Gasto gasto = new Gasto(
                    null, descripcion, fecha, monto, imagen, moneda,
                    lugar, esRecurrente, tipoGasto, impactoFinanciero,
                    activo, observaciones
            );

            Usuario usuario = usuarios.get(aleatorio.nextInt(usuarios.size()));
            Categoria categoria = categorias.get(aleatorio.nextInt(categorias.size()));
            Comercio comercio = comercios.get(aleatorio.nextInt(comercios.size()));
            MedioPago medioPago = mediosPago.get(aleatorio.nextInt(mediosPago.size()));

            gasto.setUsuario(usuario);
            gasto.setCategoria(categoria);
            gasto.setComercio(comercio);
            gasto.setMedioPago(medioPago);

            listaGastos.add(gasto);
        }

        gastoRepositorio.saveAll(listaGastos);
        System.out.println("Se han cargado " + listaGastos.size() + " registros de gastos.");
    }
}
