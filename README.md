<div align="center">

# MigajaApp

### Control de Gastos Hormiga

<img src="https://img.shields.io/badge/Spring%20Boot-4.0.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
<img src="https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
<img src="https://img.shields.io/badge/H2%20Database-En%20Memoria-0000BB?style=for-the-badge&logo=databricks&logoColor=white" />
<img src="https://img.shields.io/badge/Hibernate-JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />

<br/><br/>

> *Los pequenos gastos diarios pueden representar hasta un 30% de tus ingresos mensuales.*
> **MigajaApp** te ayuda a identificar, registrar y controlar esos **gastos hormiga** que pasan desapercibidos.

<br/>

<img src="https://img.shields.io/badge/Estado-En%20Desarrollo-yellow?style=flat-square" />
<img src="https://img.shields.io/badge/Semestre-III%20%C2%B7%20Backend%20II-purple?style=flat-square" />
<img src="https://img.shields.io/badge/CESDE-Proyecto%20Integrador-blue?style=flat-square" />

</div>

---

## Tabla de Contenidos

- [Descripcion](#descripcion)
- [Stack Tecnologico](#stack-tecnologico)
- [Arquitectura](#arquitectura)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Modelo de Datos](#modelo-de-datos)
  - [Entidades](#entidades)
  - [Enumeraciones](#enumeraciones)
  - [Diagrama de Relaciones](#diagrama-de-relaciones)
- [Endpoints REST](#endpoints-rest)
  - [Gastos](#gastos)
  - [Usuarios](#usuarios)
  - [Categorias](#categorias)
  - [Comercios](#comercios)
  - [Medios de Pago](#medios-de-pago)
- [Ejemplos de Payload](#ejemplos-de-payload)
- [Validaciones de Negocio](#validaciones-de-negocio)
- [Carga Automatica de Datos](#carga-automatica-de-datos)
- [Configuracion](#configuracion)
- [Como Ejecutar](#como-ejecutar)
- [Equipo de Desarrollo](#equipo-de-desarrollo)

---

## Descripcion

**MigajaApp** es una API REST desarrollada con **Spring Boot 4.0.3** como proyecto integrador de la materia Backend II en CESDE. Permite el registro y analisis de **gastos hormiga** — esos pequenos gastos cotidianos (cafe, snacks, suscripciones, transporte) que individualmente parecen insignificantes pero en conjunto impactan las finanzas personales.

La API expone **25 endpoints** con operaciones CRUD completas para cinco entidades de negocio, conectadas mediante relaciones JPA, con validaciones a nivel de servicio y carga automatica de datos de prueba.

### Objetivos

| Objetivo | Descripcion |
|:---:|---|
| Registrar | Gastos diarios con detalle completo: monto, fecha, lugar, tipo, recurrencia e impacto financiero (escala 1-10) |
| Categorizar | Gastos por tipo, prioridad, color e icono personalizado |
| Controlar | Medios de pago utilizados: tarjetas, billeteras digitales, efectivo |
| Gestionar | Informacion de comercios frecuentes: NIT, actividad, representante legal |
| Administrar | Perfiles de usuarios con roles diferenciados |
| Medir | Impacto financiero de cada gasto hormiga |
| Identificar | Patrones de gastos recurrentes vs ocasionales |

---

## Stack Tecnologico

<div align="center">

| Tecnologia | Version | Uso |
|:---:|:---:|---|
| <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white" /> | `4.0.3` | Framework principal para la API REST |
| <img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white" /> | `25` | Lenguaje de programacion |
| <img src="https://img.shields.io/badge/H2-0000BB?style=flat&logo=databricks&logoColor=white" /> | En memoria | Base de datos relacional embebida |
| <img src="https://img.shields.io/badge/Hibernate-59666C?style=flat&logo=hibernate&logoColor=white" /> | JPA | ORM para mapeo objeto-relacional |
| <img src="https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white" /> | 3.x | Gestor de dependencias y build |
| <img src="https://img.shields.io/badge/Jackson-000000?style=flat&logo=json&logoColor=white" /> | Incluido | Serializacion JSON |

</div>

### Dependencias Maven

```
spring-boot-starter-data-jpa       Persistencia con JPA/Hibernate
spring-boot-starter-webmvc         API REST con Spring MVC
spring-boot-h2console              Consola web para la base de datos H2
spring-boot-devtools                Hot reload en desarrollo
com.h2database:h2                   Driver H2 (scope: runtime)
spring-boot-starter-data-jpa-test   Testing de capa de datos
spring-boot-starter-webmvc-test     Testing de controladores web
```

> **GroupId:** `cesde.migaja` | **ArtifactId:** `migajaApp` | **Version:** `0.0.1-SNAPSHOT`

---

## Arquitectura

El proyecto sigue el patron **MVC en capas** de Spring Boot. Cada solicitud HTTP recorre cuatro niveles:

```
                    Solicitud HTTP
                         |
                         v
              +---------------------+
              |    Controlador      |     @RestController - Recibe peticiones y envia respuestas
              |   (REST endpoint)   |     Delega toda la logica al servicio
              +---------------------+
                         |
                         v
              +---------------------+
              |      Servicio       |     @Service - Validaciones y reglas de negocio
              | (Logica de negocio) |     Lanza ResponseStatusException si falla
              +---------------------+
                         |
                         v
              +---------------------+
              |    Repositorio      |     JpaRepository - CRUD automatico via Spring Data
              |  (Acceso a datos)   |     Queries derivados para busquedas especificas
              +---------------------+
                         |
                         v
              +---------------------+
              |      Entidad        |     @Entity - Mapeo a tablas de la BD
              |   (Modelo JPA)      |     Relaciones con @ManyToOne / @OneToMany
              +---------------------+
                         |
                         v
                   Base de Datos
                  H2 (en memoria)
```

Ademas, el proyecto incluye:
- **Configuracion CORS** que permite peticiones desde cualquier origen
- **Cargadores de datos** (`CommandLineRunner`) que insertan datos de prueba al iniciar la aplicacion

---

## Estructura del Proyecto

```
migajaApp/
|
+-- src/main/java/cesde/migaja/migajaApp/
|   |
|   +-- MigajaAppApplication.java              Punto de arranque @SpringBootApplication
|   |
|   +-- Models/                                 Entidades JPA
|   |   +-- Gasto.java                          Entidad central del sistema
|   |   +-- Usuario.java                        Usuarios que registran gastos
|   |   +-- Categoria.java                      Clasificacion tematica de gastos
|   |   +-- Comercio.java                       Establecimientos donde se gasta
|   |   +-- MedioPago.java                      Metodos de pago disponibles
|   |   +-- utils/                              Enumeraciones
|   |       +-- Franquicia.java                 VISA, MASTERCARD, AMERICAN_EXPRESS
|   |       +-- Rol.java                        ADMINISTRADOR, CLIENTE, EMPLEADO
|   |       +-- TipoDocumento.java              CC, TI, CE
|   |       +-- Estado.java                     ACTIVO, INACTIVO
|   |       +-- Prioridad.java                  BAJA, MEDIA, ALTA
|   |
|   +-- repositorios/                           Capa de acceso a datos
|   |   +-- GastoRepository.java                JpaRepository<Gasto, Integer>
|   |   +-- IUsuarioRepositorio.java            JpaRepository + queries derivados
|   |   +-- CategoriaRepository.java            JpaRepository<Categoria, Integer>
|   |   +-- Icomercio.java                      JpaRepository<Comercio, Integer>
|   |   +-- Imediodepagorepositorio.java        JpaRepository<MedioPago, Integer>
|   |
|   +-- servicios/                              Logica de negocio + validaciones
|   |   +-- GastoServicio.java                  CRUD + validacion de descripcion y monto
|   |   +-- UsuarioServicio.java                CRUD + 9 validaciones de campos
|   |   +-- CategoriaServicio.java              CRUD + 9 validaciones de campos
|   |   +-- Serviciocomercio.java               CRUD + 7 validaciones de campos
|   |   +-- Serviciomediodepago.java            CRUD + 3 validaciones de campos
|   |
|   +-- controladores/                          Endpoints REST
|   |   +-- GastoControlador.java               /migaja/v1/gasto
|   |   +-- ControladorUsuario.java             /apiMigaja/v1/usuarios
|   |   +-- CategoriaControlador.java           /migaja/v1/categoria
|   |   +-- controladorComercio.java            /apiMigaja/v1/comercios
|   |   +-- ControladorMedioPago.java           /apiMigaja/v1/medioPago
|   |
|   +-- configuracion/                          Configuracion y datos seed
|       +-- CorsConfiguracion.java              CORS abierto para consumo desde frontend
|       +-- CargarDatosUsuario.java             @Order(1) - 100 usuarios
|       +-- CargarDatosCategoria.java           @Order(2) - 20 categorias
|       +-- CargarDatosComercio.java            @Order(2) - 100 comercios
|       +-- CargarDatosMedioPago.java           @Order(3) - 50 medios de pago
|       +-- CargarDatosGasto.java               @Order(4) - 200 gastos
|
+-- src/main/resources/
|   +-- application.properties                  Configuracion de BD, JPA y H2
|
+-- src/test/java/
|   +-- MigajaAppApplicationTests.java          Test de contexto
|
+-- pom.xml                                     Dependencias Maven
+-- mvnw / mvnw.cmd                             Maven Wrapper
```

---

## Modelo de Datos

### Entidades

#### Gasto — tabla `gastos`

Entidad central del sistema. Cada gasto hormiga se relaciona con un usuario, una categoria, un comercio y un medio de pago.

| Campo | Tipo | Restricciones |
|---|---|---|
| `id` | `Integer` | PK, auto-generado (IDENTITY) |
| `descripcion` | `String` | NOT NULL, max 150 chars |
| `fecha` | `LocalDate` | NOT NULL |
| `monto` | `Double` | NOT NULL |
| `imagen` | `String` | max 255 chars |
| `moneda` | `String` | NOT NULL, max 20 chars |
| `lugar` | `String` | max 150 chars |
| `esRecurrente` | `Boolean` | NOT NULL |
| `tipoGasto` | `String` | NOT NULL, max 50 chars |
| `impactoFinanciero` | `Integer` | NOT NULL (escala 1-10) |
| `activo` | `Boolean` | NOT NULL |
| `observaciones` | `String` | max 300 chars |
| `usuario_id` | FK -> `usuarios.id` | `@ManyToOne` |
| `categoria_id` | FK -> `Categorias.id` | `@ManyToOne` |
| `comercio_id` | FK -> `comercios.id` | `@ManyToOne` |
| `medio_pago_id` | FK -> `medios_pago.id` | `@ManyToOne` |

---

#### Usuario — tabla `usuarios`

Usuarios del sistema que registran sus gastos. Posee colecciones inversas de MedioPago y Gasto.

| Campo | Tipo | Restricciones |
|---|---|---|
| `id` | `Integer` | PK, auto-generado |
| `nombre` (col: `nombre_completo`) | `String` | NOT NULL, max 50 chars |
| `tipoDocumento` (col: `tipo_documento`) | `enum TipoDocumento` | NOT NULL, `@Enumerated(STRING)` |
| `numeroDocumento` (col: `numero_documento`) | `String` | NOT NULL, UNIQUE, max 15 chars |
| `edad` | `Integer` | NOT NULL |
| `apellidos` | `String` | NOT NULL, max 50 chars |
| `email` | `String` | NOT NULL, UNIQUE, max 50 chars |
| `telefono` | `String` | NOT NULL, UNIQUE, max 10 chars |
| `direccion` | `String` | NOT NULL, max 100 chars |
| `rol` | `enum Rol` | NOT NULL, `@Enumerated(STRING)` |
| `mediosDePago` | `List<MedioPago>` | `@OneToMany`, cascade ALL, orphanRemoval |
| `gastos` | `List<Gasto>` | `@OneToMany`, cascade ALL, orphanRemoval |

---

#### Categoria — tabla `Categorias`

Clasificacion tematica para organizar los gastos.

| Campo | Tipo | Restricciones |
|---|---|---|
| `id` | `Integer` | PK, auto-generado |
| `nombre` | `String` | NOT NULL, max 100 chars (min 6 a nivel servicio) |
| `fechaCreacion` | `LocalDate` | NOT NULL |
| `responsable` | `String` | NOT NULL, max 100 chars |
| `justificacion` | `String` | max 255 chars (max 200 a nivel servicio) |
| `descripcion` | `String` | max 255 chars (max 500 a nivel servicio) |
| `prioridad` | `enum Prioridad` | NOT NULL, `@Enumerated(STRING)` |
| `color` | `String` | max 20 chars |
| `icono` | `String` | max 50 chars |
| `estado` | `enum Estado` | NOT NULL, `@Enumerated(STRING)` |
| `gastos` | `List<Gasto>` | `@OneToMany`, cascade ALL, orphanRemoval |

---

#### Comercio — tabla `comercios`

Establecimientos donde se realizan los gastos.

| Campo | Tipo | Restricciones |
|---|---|---|
| `id` | `Integer` | PK, auto-generado |
| `nit` | `Integer` | NOT NULL, UNIQUE |
| `nombre` (col: `nombre_completo`) | `String` | NOT NULL, max 50 chars |
| `correo` | `String` | NOT NULL, max 70 chars |
| `direccion` | `String` | NOT NULL, max 50 chars |
| `telefono` | `String` | NOT NULL, max 11 chars |
| `sitioWeb` (col: `sitio_Web`) | `String` | NULLABLE, max 100 chars |
| `actividad` | `String` | NOT NULL, max 200 chars |
| `representanteLegal` (col: `representante_Legal`) | `String` | NOT NULL, max 100 chars |
| `gastos` | `List<Gasto>` | `@OneToMany`, cascade ALL, orphanRemoval |

---

#### MedioPago — tabla `medios_pago`

Metodos de pago disponibles, asociados a un usuario y a multiples gastos.

| Campo | Tipo | Restricciones |
|---|---|---|
| `id` | `Integer` | PK, auto-generado |
| `nombre` (col: `nombre_franquicia`) | `String` | NOT NULL, max 50 chars |
| `franquicia` | `enum Franquicia` | NOT NULL, `@Enumerated(STRING)` |
| `estado` | `Boolean` | NOT NULL |
| `usuario_id` | FK -> `usuarios.id` | `@ManyToOne` |
| `gastos` | `List<Gasto>` | `@OneToMany`, cascade ALL, orphanRemoval |

---

### Enumeraciones

Todas se almacenan como `STRING` en la base de datos (`@Enumerated(EnumType.STRING)`).

| Enum | Valores | Uso |
|---|---|---|
| `Franquicia` | `VISA`, `MASTERCARD`, `AMERICAN_EXPRESS` | Tipo de tarjeta en MedioPago |
| `Rol` | `ADMINISTRADOR`, `CLIENTE`, `EMPLEADO` | Rol del usuario en el sistema |
| `TipoDocumento` | `CEDULA_DE_CIUDADANIA`, `TARJETA_DE_IDENTIDAD`, `CEDULA_DE_EXTRANJERIA` | Tipo de identificacion |
| `Estado` | `ACTIVO`, `INACTIVO` | Estado de una categoria |
| `Prioridad` | `BAJA`, `MEDIA`, `ALTA` | Prioridad de una categoria |

---

### Diagrama de Relaciones

```
                         +----------------+
                         |    Usuario     |
                         |  (usuarios)    |
                         +-------+--------+
                            |         |
                       1:N  |         |  1:N
                            |         |
                 +----------+    +----+----------+
                 |               |               |
                 v               v               |
          +-------------+  +-----------+         |
          |  MedioPago  |  |   Gasto   | <-------+
          |(medios_pago)|  |  (gastos) |
          +------+------+  +--+-----+--+
                 |    1:N      |     |
                 +-------------+     |
                                     |
                    +----------------+----------------+
                    |                                 |
                    v                                 v
             +-------------+                  +-------------+
             |  Categoria  |  1:N -> Gasto    |  Comercio   |  1:N -> Gasto
             | (Categorias)|                  | (comercios) |
             +-------------+                  +-------------+
```

| Relacion | Tipo | Lado Propietario (FK) |
|---|---|---|
| Usuario <-> Gasto | `@OneToMany` / `@ManyToOne` | `Gasto.usuario` |
| Usuario <-> MedioPago | `@OneToMany` / `@ManyToOne` | `MedioPago.usuario` |
| Categoria <-> Gasto | `@OneToMany` / `@ManyToOne` | `Gasto.categoria` |
| Comercio <-> Gasto | `@OneToMany` / `@ManyToOne` | `Gasto.comercio` |
| MedioPago <-> Gasto | `@OneToMany` / `@ManyToOne` | `Gasto.medioPago` |

> Las colecciones inversas (`@OneToMany`) usan `@JsonIgnore` para evitar ciclos infinitos al serializar a JSON.
> Todas las relaciones `@OneToMany` tienen `cascade = CascadeType.ALL` y `orphanRemoval = true`.

---

## Endpoints REST

**Host base:** `http://localhost:8080`

### Gastos

**Base:** `/migaja/v1/gasto`

| Metodo | Ruta | Descripcion | Status |
|:---:|---|---|:---:|
| `POST` | `/migaja/v1/gasto` | Crear un nuevo gasto | `200 OK` |
| `GET` | `/migaja/v1/gasto` | Listar todos los gastos | `200 OK` |
| `GET` | `/migaja/v1/gasto/buscarPorId/{id}` | Buscar gasto por ID | `200 OK` |
| `PUT` | `/migaja/v1/gasto/actualizar/{id}` | Actualizar un gasto existente | `200 OK` |
| `DELETE` | `/migaja/v1/gasto/delete/{id}` | Eliminar un gasto | `200 OK` |

---

### Usuarios

**Base:** `/apiMigaja/v1/usuarios`

| Metodo | Ruta | Descripcion | Status |
|:---:|---|---|:---:|
| `POST` | `/apiMigaja/v1/usuarios` | Crear un nuevo usuario | `201 CREATED` |
| `GET` | `/apiMigaja/v1/usuarios` | Listar todos los usuarios | `200 OK` |
| `GET` | `/apiMigaja/v1/usuarios/{id}` | Buscar usuario por ID | `200 OK` |
| `PUT` | `/apiMigaja/v1/usuarios/{id}` | Actualizar usuario | `200 OK` |
| `DELETE` | `/apiMigaja/v1/usuarios/{id}` | Eliminar usuario | `200 OK` |

---

### Categorias

**Base:** `/migaja/v1/categoria`

| Metodo | Ruta | Descripcion | Status |
|:---:|---|---|:---:|
| `POST` | `/migaja/v1/categoria` | Crear una nueva categoria | `200 OK` |
| `GET` | `/migaja/v1/categoria` | Listar todas las categorias | `200 OK` |
| `GET` | `/migaja/v1/categoria/{id}` | Obtener categoria por ID | `200 OK` |
| `PUT` | `/migaja/v1/categoria/{id}` | Editar una categoria | `200 OK` |
| `DELETE` | `/migaja/v1/categoria/{id}` | Eliminar una categoria | `200 OK` |

---

### Comercios

**Base:** `/apiMigaja/v1/comercios`

| Metodo | Ruta | Descripcion | Status |
|:---:|---|---|:---:|
| `POST` | `/apiMigaja/v1/comercios` | Crear un comercio | `200 OK` |
| `GET` | `/apiMigaja/v1/comercios` | Listar todos los comercios | `200 OK` |
| `GET` | `/apiMigaja/v1/comercios/{id}` | Buscar comercio por ID | `200 OK` |
| `PUT` | `/apiMigaja/v1/comercios/{id}` | Actualizar comercio | `200 OK` |
| `DELETE` | `/apiMigaja/v1/comercios/{id}` | Eliminar comercio | `200 OK` |

---

### Medios de Pago

**Base:** `/apiMigaja/v1/medioPago`

| Metodo | Ruta | Descripcion | Status |
|:---:|---|---|:---:|
| `POST` | `/apiMigaja/v1/medioPago` | Crear medio de pago | `200 OK` |
| `GET` | `/apiMigaja/v1/medioPago` | Listar medios de pago | `200 OK` |
| `GET` | `/apiMigaja/v1/medioPago/{id}` | Buscar medio de pago por ID | `200 OK` |
| `PUT` | `/apiMigaja/v1/medioPago/{id}` | Actualizar medio de pago | `200 OK` |
| `DELETE` | `/apiMigaja/v1/medioPago/{id}` | Eliminar medio de pago | `200 OK` |

---

## Ejemplos de Payload

<details>
<summary><b>POST /apiMigaja/v1/usuarios</b> — Crear usuario</summary>

```json
{
  "nombre": "Mateo",
  "apellidos": "Arcila",
  "tipoDocumento": "CEDULA_DE_CIUDADANIA",
  "numeroDocumento": "1023456789",
  "edad": 25,
  "email": "mateo@migaja.com",
  "telefono": "3001234567",
  "direccion": "Calle 10 # 20-30",
  "rol": "CLIENTE"
}
```
</details>

<details>
<summary><b>POST /migaja/v1/categoria</b> — Crear categoria</summary>

```json
{
  "nombre": "Alimentacion",
  "fechaCreacion": "2026-05-09",
  "responsable": "Mateo",
  "justificacion": "Gastos asociados a comida y bebida",
  "descripcion": "Categoria para todo gasto en alimentos",
  "prioridad": "ALTA",
  "color": "#FF5733",
  "icono": "comida",
  "estado": "ACTIVO"
}
```
</details>

<details>
<summary><b>POST /apiMigaja/v1/comercios</b> — Crear comercio</summary>

```json
{
  "nit": 900123456,
  "nombre": "Tienda La Esquina",
  "correo": "contacto@laesquina.com",
  "direccion": "Calle 10 # 20-30",
  "telefono": "3001234567",
  "sitioWeb": "https://laesquina.com",
  "actividad": "Venta de productos de consumo masivo",
  "representanteLegal": "Mateo Arcila"
}
```
</details>

<details>
<summary><b>POST /apiMigaja/v1/medioPago</b> — Crear medio de pago</summary>

```json
{
  "nombre": "Bancolombia 1234",
  "franquicia": "VISA",
  "estado": true
}
```
</details>

<details>
<summary><b>POST /migaja/v1/gasto</b> — Crear gasto</summary>

```json
{
  "descripcion": "Almuerzo del dia",
  "fecha": "2026-05-09",
  "monto": 18500.00,
  "imagen": "almuerzo.png",
  "moneda": "COP",
  "lugar": "Medellin",
  "esRecurrente": true,
  "tipoGasto": "VARIABLE",
  "impactoFinanciero": 4,
  "activo": true,
  "observaciones": "Almuerzo en restaurante cercano",
  "usuario": { "id": 1 },
  "categoria": { "id": 1 },
  "comercio": { "id": 1 },
  "medioPago": { "id": 1 }
}
```
</details>

---

## Validaciones de Negocio

Los servicios validan los datos antes de persistirlos y lanzan `ResponseStatusException` con el codigo HTTP apropiado.

### UsuarioServicio — 9 validaciones

| Campo | Regla | Error |
|---|---|---|
| `nombre` | No puede estar vacio ni en blanco | `400 BAD_REQUEST` |
| `apellidos` | No puede estar vacio ni en blanco | `400 BAD_REQUEST` |
| `tipoDocumento` | Requerido (no null) | `400 BAD_REQUEST` |
| `numeroDocumento` | Minimo 6 caracteres | `400 BAD_REQUEST` |
| `edad` | Requerida y mayor a 0 | `400 BAD_REQUEST` |
| `email` | No puede estar vacio ni en blanco | `400 BAD_REQUEST` |
| `telefono` | No puede estar vacio ni en blanco | `400 BAD_REQUEST` |
| `direccion` | No puede estar vacio ni en blanco | `400 BAD_REQUEST` |
| `rol` | Requerido (no null) | `400 BAD_REQUEST` |

### CategoriaServicio — 9 validaciones

| Campo | Regla | Error |
|---|---|---|
| `nombre` | Obligatorio, minimo 6 caracteres | `400 BAD_REQUEST` |
| `fechaCreacion` | Obligatoria (no null) | `400 BAD_REQUEST` |
| `responsable` | Obligatorio, no vacio | `400 BAD_REQUEST` |
| `prioridad` | Obligatoria (no null) | `400 BAD_REQUEST` |
| `estado` | Obligatorio (no null) | `400 BAD_REQUEST` |
| `color` | Maximo 20 caracteres | `400 BAD_REQUEST` |
| `icono` | Maximo 50 caracteres | `400 BAD_REQUEST` |
| `justificacion` | Maximo 200 caracteres | `400 BAD_REQUEST` |
| `descripcion` | Maximo 500 caracteres | `400 BAD_REQUEST` |

### Serviciocomercio — 7 validaciones

| Campo | Regla | Error |
|---|---|---|
| `nombre` | No puede estar vacio | `400 BAD_REQUEST` |
| `nit` | Requerido (no null) | `400 BAD_REQUEST` |
| `direccion` | No puede estar vacia | `400 BAD_REQUEST` |
| `telefono` | No puede estar vacio | `400 BAD_REQUEST` |
| `correo` | No puede estar vacio | `400 BAD_REQUEST` |
| `representanteLegal` | No puede estar vacio | `400 BAD_REQUEST` |
| `actividad` | No puede estar vacia | `400 BAD_REQUEST` |

> Las mismas validaciones se aplican tanto al crear como al actualizar un comercio.

### Serviciomediodepago — 3 validaciones

| Campo | Regla | Error |
|---|---|---|
| `nombre` | No puede estar vacio | `400 BAD_REQUEST` |
| `franquicia` | Requerida (no null) | `400 BAD_REQUEST` |
| `estado` | Requerido (no null) | `400 BAD_REQUEST` |

### GastoServicio — 3 validaciones

| Campo | Regla | Error |
|---|---|---|
| `descripcion` | Obligatoria, no en blanco | `400 BAD_REQUEST` |
| `monto` | Obligatorio (no null) | `400 BAD_REQUEST` |
| `monto` | Debe ser un numero valido (no NaN) | `400 BAD_REQUEST` |

> En todos los servicios, las busquedas, actualizaciones y eliminaciones por ID inexistente retornan `404 NOT_FOUND`.

---

## Carga Automatica de Datos

Al iniciar la aplicacion, cinco `CommandLineRunner` (anotados con `@Order`) cargan datos de prueba en orden controlado para respetar las dependencias entre entidades:

| Orden | Componente | Registros | Descripcion |
|:---:|---|:---:|---|
| 1 | `CargarDatosUsuario` | **100** | Usuarios con nombres, documentos, roles y direcciones colombianas |
| 2 | `CargarDatosCategoria` | **20** | Categorias (Alimentacion, Transporte, Salud, etc.) con colores e iconos |
| 2 | `CargarDatosComercio` | **100** | Comercios con NIT unico, actividad, direccion y representante legal |
| 3 | `CargarDatosMedioPago` | **50** | Medios de pago de bancos colombianos asociados a usuarios existentes |
| 4 | `CargarDatosGasto` | **200** | Gastos asociados aleatoriamente a usuario, categoria, comercio y medio de pago |

**Total: 470 registros** generados automaticamente en cada inicio.

> Todos los generadores usan `Random(42)` como semilla, garantizando datos **reproducibles** entre ejecuciones.

> Como `spring.jpa.hibernate.ddl-auto=create`, el esquema y los datos se recrean en cada arranque.

---

## Configuracion

### application.properties

```properties
# Nombre de la aplicacion
spring.application.name=migajaApp

# Base de datos H2 en memoria
spring.datasource.url=jdbc:h2:mem:hormiga_gasto
spring.datasource.username=sa
spring.datasource.password=

# Consola H2 habilitada
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

### CORS

La configuracion CORS (`CorsConfiguracion.java`) permite el consumo de la API desde cualquier origen:

```
Origenes permitidos:    *  (todos)
Metodos permitidos:     GET, POST, PUT, DELETE, OPTIONS
Headers permitidos:     *  (todos)
```

---

## Como Ejecutar

### Prerrequisitos

- **Java 25** o superior
- **Maven 3.x** (o usar el wrapper incluido)

### Pasos

```bash
# 1. Clonar el repositorio
git clone <url-del-repositorio>
cd migajaApp

# 2. Compilar el proyecto
./mvnw clean install

# 3. Ejecutar la aplicacion
./mvnw spring-boot:run
```

> En Windows usar `mvnw.cmd` en lugar de `./mvnw`.

### Accesos

| Recurso | URL |
|---|---|
| API Base | `http://localhost:8080` |
| Consola H2 | `http://localhost:8080/h2-console` |
| JDBC URL | `jdbc:h2:mem:hormiga_gasto` |
| Usuario BD | `sa` |
| Contrasena | *(vacia)* |

### Probar los endpoints

Se puede usar **Postman**, **Insomnia**, **Thunder Client** o `curl`:

```bash
# Listar todos los usuarios
curl http://localhost:8080/apiMigaja/v1/usuarios

# Listar todas las categorias
curl http://localhost:8080/migaja/v1/categoria

# Listar todos los gastos
curl http://localhost:8080/migaja/v1/gasto

# Listar todos los comercios
curl http://localhost:8080/apiMigaja/v1/comercios

# Listar todos los medios de pago
curl http://localhost:8080/apiMigaja/v1/medioPago
```

---

## Equipo de Desarrollo

<div align="center">

<table>
  <tr>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Mateo+Arcila&background=6DB33F&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Mateo"/>
      <br />
      <sub><b>Mateo Arcila Patino</b></sub>
      <br/>
      <sub>Modulo de Usuarios</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Luz+Zabala&background=ED8B00&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Luz"/>
      <br />
      <sub><b>Luz Marycelda Zabala Gutierrez</b></sub>
      <br/>
      <sub>Modulo de Medio de Pago</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Emanuel+Zuluaga&background=8E44AD&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Emanuel"/>
      <br />
      <sub><b>Emanuel Zuluaga</b></sub>
      <br/>
      <sub>Modulo de Gasto</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Pablo+Lopera&background=0078D4&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Pablo"/>
      <br />
      <sub><b>Pablo Andres Moreno Lopera</b></sub>
      <br/>
      <sub>Modulo de Comercio</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Nicolas+Marulanda&background=C71A36&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Nicolas"/>
      <br />
      <sub><b>Nicolas Marulanda Alvarez</b></sub>
      <br/>
      <sub>Modulo de Categoria</sub>
    </td>
  </tr>
</table>

</div>

---

<div align="center">

### *"Cada migaja cuenta... y cada gasto hormiga tambien!"*

<br/>

CESDE — Proyecto Integrador Backend II — Semestre III — 2026

</div>
