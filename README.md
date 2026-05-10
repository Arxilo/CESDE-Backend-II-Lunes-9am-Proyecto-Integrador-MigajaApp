<div align="center">

# 🐜 MigajaApp — Control de Gastos Hormiga

<img src="https://img.shields.io/badge/Spring%20Boot-4.0.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
<img src="https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
<img src="https://img.shields.io/badge/H2%20Database-En%20Memoria-0000BB?style=for-the-badge&logo=databricks&logoColor=white" />
<img src="https://img.shields.io/badge/Hibernate-JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />

<br/><br/>

> *¿Sabías que los pequeños gastos diarios pueden representar hasta un 30% de tus ingresos mensuales?*
> **MigajaApp** nace para ayudarte a identificar, registrar y controlar esos **gastos hormiga** que pasan desapercibidos. 🎯💰

<br/>

<img src="https://img.shields.io/badge/Estado-En%20Desarrollo%20🚧-yellow?style=flat-square" />
<img src="https://img.shields.io/badge/Semestre-III%20·%20Backend%20II-purple?style=flat-square" />
<img src="https://img.shields.io/badge/Institución-CESDE-blue?style=flat-square" />

</div>

---

## 📑 Tabla de Contenidos

- [🐜 Descripción del Proyecto](#-descripción-del-proyecto)
- [🏗️ Arquitectura y Estructura](#️-arquitectura-y-estructura)
- [⚙️ Stack Tecnológico](#️-stack-tecnológico)
- [🗃️ Modelos de Datos](#️-modelos-de-datos)
- [🔗 Relaciones entre Entidades](#-relaciones-entre-entidades)
- [🎨 Enumeraciones](#-enumeraciones)
- [🌐 Endpoints REST](#-endpoints-rest)
- [🛡️ Validaciones de Servicios](#️-validaciones-de-servicios)
- [🌱 Carga Automática de Datos](#-carga-automática-de-datos)
- [🔧 Configuración](#-configuración)
- [🚀 Cómo Ejecutar](#-cómo-ejecutar)
- [👥 Equipo de Desarrollo](#-equipo-de-desarrollo)

---

## 🐜 Descripción del Proyecto

**MigajaApp** es una API REST desarrollada con **Spring Boot** como proyecto integrador de la materia **Backend II** en **CESDE**. Su objetivo principal es brindar una herramienta para el registro y análisis de **gastos hormiga** — esos pequeños gastos cotidianos (café, snacks, suscripciones, transporte, etc.) que individualmente parecen insignificantes, pero que en conjunto impactan significativamente las finanzas personales.

La aplicación expone una API REST completa con **operaciones CRUD** para cinco entidades de negocio (Usuario, Categoría, Comercio, Medio de Pago y Gasto), todas conectadas mediante relaciones JPA, con una capa de validación a nivel de servicio y carga automática de datos de prueba al iniciar la aplicación.

### 🎯 Objetivos
| | Objetivo |
|---|----------|
| 📊 | Registrar gastos diarios con detalle completo (monto, fecha, lugar, tipo, recurrencia, impacto) |
| 🏷️ | Categorizar gastos por tipo, prioridad, color e ícono |
| 💳 | Controlar los medios de pago utilizados (tarjetas, billeteras digitales, efectivo) |
| 🏪 | Gestionar información de comercios frecuentes (NIT, actividad, representante legal) |
| 👤 | Administrar perfiles de usuarios con roles diferenciados |
| 📈 | Medir el impacto financiero (escala 1–10) de los gastos hormiga |
| 🔁 | Identificar gastos recurrentes vs ocasionales |

---

## 🏗️ Arquitectura y Estructura

El proyecto sigue el patrón **MVC en capas** propio de Spring Boot:

```
Controlador (REST) → Servicio (Reglas de negocio) → Repositorio (JPA) → Entidad (Modelo)
```

```
🐜 migajaApp/
│
├── 📂 .mvn/wrapper/                              # Maven Wrapper
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/cesde/migaja/migajaApp/
│   │   │   ├── 🚀 MigajaAppApplication.java      # Punto de arranque @SpringBootApplication
│   │   │   │
│   │   │   ├── 📂 Models/                        # Entidades JPA
│   │   │   │   ├── 💸 Gasto.java
│   │   │   │   ├── 👤 Usuario.java
│   │   │   │   ├── 🏷️ Categoria.java
│   │   │   │   ├── 🏪 Comercio.java
│   │   │   │   ├── 💳 MedioPago.java
│   │   │   │   └── 📂 utils/                     # Enumeraciones
│   │   │   │       ├── Franquicia.java
│   │   │   │       ├── Rol.java
│   │   │   │       ├── TipoDocumento.java
│   │   │   │       ├── Estado.java
│   │   │   │       └── Prioridad.java
│   │   │   │
│   │   │   ├── 📂 repositorios/                  # Capa de acceso a datos (JpaRepository)
│   │   │   │   ├── GastoRepository.java
│   │   │   │   ├── IUsuarioRepositorio.java
│   │   │   │   ├── CategoriaRepository.java
│   │   │   │   ├── Icomercio.java
│   │   │   │   └── Imediodepagorepositorio.java
│   │   │   │
│   │   │   ├── 📂 servicios/                     # Lógica de negocio + validaciones
│   │   │   │   ├── GastoServicio.java
│   │   │   │   ├── UsuarioServicio.java
│   │   │   │   ├── CategoriaServicio.java
│   │   │   │   ├── Serviciocomercio.java
│   │   │   │   └── Serviciomediodepago.java
│   │   │   │
│   │   │   ├── 📂 controladores/                 # Endpoints REST (@RestController)
│   │   │   │   ├── GastoControlador.java
│   │   │   │   ├── ControladorUsuario.java
│   │   │   │   ├── CategoriaControlador.java
│   │   │   │   ├── controladorComercio.java
│   │   │   │   └── ControladorMedioPago.java
│   │   │   │
│   │   │   └── 📂 configuracion/                 # CommandLineRunners para datos seed
│   │   │       ├── CargarDatosUsuario.java       # @Order(1)
│   │   │       ├── CargarDatosCategoria.java     # @Order(2)
│   │   │       ├── CargarDatosComercio.java      # @Order(2)
│   │   │       ├── CargarDatosMedioPago.java     # @Order(3)
│   │   │       └── CargarDatosGasto.java         # @Order(4)
│   │   │
│   │   └── 📂 resources/
│   │       └── ⚙️ application.properties
│   │
│   └── 📂 test/
│       └── 🧪 MigajaAppApplicationTests.java
│
├── 📄 pom.xml
├── 📄 mvnw / mvnw.cmd
└── 📄 README.md
```

---

## ⚙️ Stack Tecnológico

<div align="center">

| 🔧 Tecnología | 📌 Versión | 📝 Descripción |
|:---:|:---:|:---|
| <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white" /> | `4.0.3` | Framework principal para la API REST |
| <img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white" /> | `25` | Lenguaje de programación |
| <img src="https://img.shields.io/badge/H2-0000BB?style=flat&logo=databricks&logoColor=white" /> | `En memoria` | Base de datos relacional embebida |
| <img src="https://img.shields.io/badge/Hibernate-59666C?style=flat&logo=hibernate&logoColor=white" /> | `JPA` | ORM para mapeo objeto-relacional |
| <img src="https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white" /> | `3.x` | Gestor de dependencias y build |
| <img src="https://img.shields.io/badge/Jackson-000000?style=flat&logo=json&logoColor=white" /> | `incluido` | Serialización JSON (`@JsonIgnore` para evitar ciclos) |

</div>

### 📦 Dependencias Maven (`pom.xml`)

```xml
🟢 spring-boot-starter-data-jpa      → Persistencia con JPA/Hibernate
🟢 spring-boot-starter-webmvc        → API REST con Spring MVC
🟡 spring-boot-h2console             → Consola web para la base de datos H2
🔵 spring-boot-devtools              → Hot reload en desarrollo
🟣 com.h2database:h2                 → Driver H2 (scope: runtime)
🧪 spring-boot-starter-data-jpa-test → Testing de capa de datos
🧪 spring-boot-starter-webmvc-test   → Testing de controladores web
```

> **GroupId:** `cesde.migaja` · **ArtifactId:** `migajaApp` · **Versión:** `0.0.1-SNAPSHOT`

---

## 🗃️ Modelos de Datos

### 💸 Gasto — `gastos`
> *Entidad principal que representa cada gasto hormiga registrado. Se relaciona con Usuario, Categoría, Comercio y Medio de Pago.*

| 🏷️ Campo | 📋 Tipo | 🔒 Restricciones |
|-----------|---------|-------------------|
| `id` | `Integer` | 🔑 PK, Auto-generado (`IDENTITY`) |
| `descripcion` | `String` | ⚠️ NOT NULL, máx 150 chars |
| `fecha` | `LocalDate` | ⚠️ NOT NULL |
| `monto` | `Double` | ⚠️ NOT NULL |
| `imagen` | `String` | máx 255 chars |
| `moneda` | `String` | ⚠️ NOT NULL, máx 20 chars |
| `lugar` | `String` | máx 150 chars |
| `esRecurrente` | `Boolean` | ⚠️ NOT NULL |
| `tipoGasto` | `String` | ⚠️ NOT NULL, máx 50 chars |
| `impactoFinanciero` | `Integer` | ⚠️ NOT NULL (escala 1–10) |
| `activo` | `Boolean` | ⚠️ NOT NULL |
| `observaciones` | `String` | máx 300 chars |
| `usuario_id` | `FK → usuarios.id` | `@ManyToOne` |
| `categoria_id` | `FK → Categorias.id` | `@ManyToOne` |
| `comercio_id` | `FK → comercios.id` | `@ManyToOne` |
| `medio_pago_id` | `FK → medios_pago.id` | `@ManyToOne` |

---

### 👤 Usuario — `usuarios`
> *Usuarios del sistema que registran sus gastos. Posee colecciones inversas de `MedioPago` y `Gasto`.*

| 🏷️ Campo | 📋 Tipo | 🔒 Restricciones |
|-----------|---------|-------------------|
| `id` | `Integer` | 🔑 PK, Auto-generado |
| `nombre` (`nombre_completo`) | `String` | ⚠️ NOT NULL, máx 50 chars |
| `tipoDocumento` | `enum TipoDocumento` | ⚠️ NOT NULL (`@Enumerated(STRING)`) |
| `numeroDocumento` | `String` | ⚠️ NOT NULL, ÚNICO, máx 15 chars |
| `edad` | `Integer` | ⚠️ NOT NULL |
| `apellidos` | `String` | ⚠️ NOT NULL, máx 50 chars |
| `email` | `String` | ⚠️ NOT NULL, ÚNICO, máx 50 chars |
| `telefono` | `String` | ⚠️ NOT NULL, ÚNICO, máx 10 chars |
| `direccion` | `String` | ⚠️ NOT NULL, máx 100 chars |
| `rol` | `enum Rol` | ⚠️ NOT NULL (`@Enumerated(STRING)`) |
| `mediosDePago` | `List<MedioPago>` | `@OneToMany`, `cascade=ALL`, `orphanRemoval=true` |
| `gastos` | `List<Gasto>` | `@OneToMany`, `cascade=ALL`, `orphanRemoval=true` |

---

### 🏷️ Categoría — `Categorias`
> *Clasificación temática para organizar los gastos.*

| 🏷️ Campo | 📋 Tipo | 🔒 Restricciones |
|-----------|---------|-------------------|
| `id` | `Integer` | 🔑 PK, Auto-generado |
| `nombre` | `String` | ⚠️ NOT NULL, máx 100 chars (mín 6 a nivel servicio) |
| `fechaCreacion` | `LocalDate` | ⚠️ NOT NULL |
| `responsable` | `String` | ⚠️ NOT NULL, máx 100 chars |
| `justificacion` | `String` | máx 255 chars (≤200 a nivel servicio) |
| `descripcion` | `String` | máx 255 chars (≤500 a nivel servicio) |
| `prioridad` | `enum Prioridad` | ⚠️ NOT NULL (`@Enumerated(STRING)`) |
| `color` | `String` | máx 20 chars |
| `icono` | `String` | máx 50 chars |
| `estado` | `enum Estado` | ⚠️ NOT NULL (`@Enumerated(STRING)`) |
| `gastos` | `List<Gasto>` | `@OneToMany`, `cascade=ALL`, `orphanRemoval=true` |

---

### 💳 Medio de Pago — `medios_pago`
> *Métodos de pago disponibles, asociados a un Usuario y a múltiples Gastos.*

| 🏷️ Campo | 📋 Tipo | 🔒 Restricciones |
|-----------|---------|-------------------|
| `id` | `Integer` | 🔑 PK, Auto-generado |
| `nombre` (`nombre_franquicia`) | `String` | ⚠️ NOT NULL, máx 50 chars |
| `franquicia` | `enum Franquicia` | ⚠️ NOT NULL (`@Enumerated(STRING)`) |
| `estado` | `Boolean` | ⚠️ NOT NULL |
| `usuario_id` | `FK → usuarios.id` | `@ManyToOne` |
| `gastos` | `List<Gasto>` | `@OneToMany`, `cascade=ALL`, `orphanRemoval=true` |

---

### 🏪 Comercio — `comercios`
> *Establecimientos donde se realizan los gastos.*

| 🏷️ Campo | 📋 Tipo | 🔒 Restricciones |
|-----------|---------|-------------------|
| `id` | `Integer` | 🔑 PK, Auto-generado |
| `nit` | `Integer` | ⚠️ NOT NULL, ÚNICO |
| `nombre` (`nombre_completo`) | `String` | ⚠️ NOT NULL, máx 50 chars |
| `correo` | `String` | ⚠️ NOT NULL, máx 70 chars |
| `direccion` | `String` | ⚠️ NOT NULL, máx 50 chars |
| `telefono` | `String` | ⚠️ NOT NULL, máx 11 chars |
| `sitioWeb` (`sitio_Web`) | `String` | NULLABLE, máx 100 chars |
| `actividad` | `String` | ⚠️ NOT NULL, máx 200 chars |
| `representanteLegal` (`representante_Legal`) | `String` | ⚠️ NOT NULL, máx 100 chars |
| `gastos` | `List<Gasto>` | `@OneToMany`, `cascade=ALL`, `orphanRemoval=true` |

---

## 🔗 Relaciones entre Entidades

```
                         ┌──────────────┐
                         │   Usuario    │
                         │  (usuarios)  │
                         └──────┬───────┘
                       1:N      │      1:N
                  ┌─────────────┼─────────────┐
                  ▼             │             ▼
          ┌──────────────┐      │      ┌──────────────┐
          │  MedioPago   │      │      │    Gasto     │
          │(medios_pago) │      │      │   (gastos)   │
          └──────┬───────┘      │      └──┬────┬──────┘
                 │ 1:N          │ 1:N     │    │
                 └──────────────┴─────────┘    │
                                               │
                       ┌───────────────────────┴─────────┐
                       ▼                                 ▼
                ┌──────────────┐                 ┌──────────────┐
                │  Categoria   │ 1:N → Gasto     │   Comercio   │ 1:N → Gasto
                │ (Categorias) │                 │  (comercios) │
                └──────────────┘                 └──────────────┘
```

| Relación | Tipo | Lado Propietario |
|----------|------|------------------|
| `Usuario` ⇄ `Gasto` | `@OneToMany` / `@ManyToOne` | `Gasto.usuario` |
| `Usuario` ⇄ `MedioPago` | `@OneToMany` / `@ManyToOne` | `MedioPago.usuario` |
| `Categoria` ⇄ `Gasto` | `@OneToMany` / `@ManyToOne` | `Gasto.categoria` |
| `Comercio` ⇄ `Gasto` | `@OneToMany` / `@ManyToOne` | `Gasto.comercio` |
| `MedioPago` ⇄ `Gasto` | `@OneToMany` / `@ManyToOne` | `Gasto.medioPago` |

> 💡 Las colecciones inversas usan `@JsonIgnore` para evitar ciclos infinitos al serializar a JSON.

---

## 🎨 Enumeraciones

Se almacenan como `STRING` en la base de datos (`@Enumerated(EnumType.STRING)`).

| Enum | Valores |
|------|---------|
| 💳 **`Franquicia`** | `VISA` · `MASTERCARD` · `AMERICAN_EXPRESS` |
| 👥 **`Rol`** | `ADMINISTRADOR` · `CLIENTE` · `EMPLEADO` |
| 🪪 **`TipoDocumento`** | `CEDULA_DE_CIUDADANIA` · `TARJETA_DE_IDENTIDAD` · `CEDULA_DE_EXTRANJERIA` |
| 🚦 **`Estado`** | `ACTIVO` · `INACTIVO` |
| ⭐ **`Prioridad`** | `BAJA` · `MEDIA` · `ALTA` |

---

## 🌐 Endpoints REST

> 🌍 **Host base:** `http://localhost:8080`

### 💸 Gastos — `/migaja/v1/gasto`

| Método | Ruta | Descripción |
|:------:|------|-------------|
| 🟢 `POST` | `/migaja/v1/gasto` | Crear un nuevo gasto |
| 🔵 `GET` | `/migaja/v1/gasto` | Listar todos los gastos |
| 🔵 `GET` | `/migaja/v1/gasto/buscarPorId/{id}` | Buscar gasto por ID |
| 🟡 `PUT` | `/migaja/v1/gasto/actualizar/{id}` | Actualizar un gasto existente |
| 🔴 `DELETE` | `/migaja/v1/gasto/delete/{id}` | Eliminar un gasto |

### 🏷️ Categorías — `/migaja/v1/categoria`

| Método | Ruta | Descripción |
|:------:|------|-------------|
| 🟢 `POST` | `/migaja/v1/categoria` | Crear una nueva categoría |
| 🔵 `GET` | `/migaja/v1/categoria` | Listar todas las categorías |
| 🔵 `GET` | `/migaja/v1/categoria/{id}` | Obtener categoría por ID |
| 🟡 `PUT` | `/migaja/v1/categoria/{id}` | Editar una categoría |
| 🔴 `DELETE` | `/migaja/v1/categoria/{id}` | Eliminar una categoría |

### 👤 Usuarios — `/apiMigaja/v1/usuarios`

| Método | Ruta | Descripción | Status |
|:------:|------|-------------|:------:|
| 🟢 `POST` | `/apiMigaja/v1/usuarios` | Crear un nuevo usuario | `201 CREATED` |
| 🔵 `GET` | `/apiMigaja/v1/usuarios` | Listar todos los usuarios | `200 OK` |
| 🔵 `GET` | `/apiMigaja/v1/usuarios/{id}` | Buscar usuario por ID | `200 OK` |
| 🟡 `PUT` | `/apiMigaja/v1/usuarios/{id}` | Actualizar usuario | `200 OK` |
| 🔴 `DELETE` | `/apiMigaja/v1/usuarios/{id}` | Eliminar usuario | `200 OK` |

### 🏪 Comercios — `/apiMigaja/v1/comercios`

| Método | Ruta | Descripción |
|:------:|------|-------------|
| 🟢 `POST` | `/apiMigaja/v1/comercios` | Crear un comercio |
| 🔵 `GET` | `/apiMigaja/v1/comercios` | Listar todos los comercios |
| 🔵 `GET` | `/apiMigaja/v1/comercios/{id}` | Buscar comercio por ID |
| 🟡 `PUT` | `/apiMigaja/v1/comercios/{id}` | Actualizar comercio |
| 🔴 `DELETE` | `/apiMigaja/v1/comercios/{id}` | Eliminar comercio |

### 💳 Medios de Pago — `/apiMigaja/v1/medioPago`

| Método | Ruta | Descripción |
|:------:|------|-------------|
| 🟢 `POST` | `/apiMigaja/v1/medioPago` | Crear medio de pago |
| 🔵 `GET` | `/apiMigaja/v1/medioPago` | Listar medios de pago |
| 🔵 `GET` | `/apiMigaja/v1/medioPago/{id}` | Buscar medio de pago por ID |
| 🟡 `PUT` | `/apiMigaja/v1/medioPago/{id}` | Actualizar medio de pago |
| 🔴 `DELETE` | `/apiMigaja/v1/medioPago/{id}` | Eliminar medio de pago |

---

### 📥 Ejemplos de Payload (JSON)

<details>
<summary><b>👤 POST <code>/apiMigaja/v1/usuarios</code></b></summary>

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
<summary><b>🏷️ POST <code>/migaja/v1/categoria</code></b></summary>

```json
{
  "nombre": "Alimentación",
  "fechaCreacion": "2026-05-09",
  "responsable": "Mateo",
  "justificacion": "Gastos asociados a comida y bebida",
  "descripcion": "Categoría para todo gasto en alimentos",
  "prioridad": "ALTA",
  "color": "#FF5733",
  "icono": "🍴",
  "estado": "ACTIVO"
}
```
</details>

<details>
<summary><b>💳 POST <code>/apiMigaja/v1/medioPago</code></b></summary>

```json
{
  "nombre": "Bancolombia 1234",
  "franquicia": "VISA",
  "estado": true
}
```
</details>

<details>
<summary><b>🏪 POST <code>/apiMigaja/v1/comercios</code></b></summary>

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
<summary><b>💸 POST <code>/migaja/v1/gasto</code></b></summary>

```json
{
  "descripcion": "Almuerzo del día",
  "fecha": "2026-05-09",
  "monto": 18500.00,
  "imagen": "almuerzo.png",
  "moneda": "COP",
  "lugar": "Medellín",
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

## 🛡️ Validaciones de Servicios

Los servicios validan los datos antes de persistirlos y lanzan `ResponseStatusException` cuando algún requisito falla.

### 👤 `UsuarioServicio`
- Nombre, apellidos, dirección, teléfono y email **no pueden estar vacíos** (`400 BAD_REQUEST`).
- `tipoDocumento` y `rol` son **requeridos**.
- `numeroDocumento` debe tener **al menos 6 caracteres**.
- `edad` requerida y **mayor a 0**.
- ID inexistente al actualizar/eliminar/buscar → `404 NOT_FOUND`.

### 🏷️ `CategoriaServicio`
- `nombre`, `fechaCreacion`, `responsable`, `prioridad` y `estado` son obligatorios.
- `nombre` ≥ 6 caracteres.
- `color` ≤ 20, `icono` ≤ 50, `justificacion` ≤ 200, `descripcion` ≤ 500 caracteres.

### 🏪 `Serviciocomercio`
- `nombre`, `nit`, `direccion`, `telefono`, `correo`, `representanteLegal` y `actividad` no pueden estar vacíos.
- Mismas validaciones se aplican al actualizar.

### 💳 `Serviciomediodepago`
- `nombre`, `franquicia` y `estado` son obligatorios.

### 💸 `GastoServicio`
- `descripcion` y `monto` son obligatorios.
- `monto` debe ser un número válido (no `NaN`).

> En todos los casos, **las búsquedas/actualizaciones/eliminaciones por ID inexistente** retornan `404 NOT_FOUND`.

---

## 🌱 Carga Automática de Datos

Al iniciar la aplicación, cinco `CommandLineRunner` (anotados con `@Order`) cargan datos de prueba en orden controlado para respetar las dependencias entre entidades:

| Orden | Componente | Registros | Descripción |
|:-----:|------------|:---------:|-------------|
| **1** | `CargarDatosUsuario` | **100** | Usuarios aleatorios con nombres, documentos, roles y direcciones colombianas |
| **2** | `CargarDatosCategoria` | **20** | Categorías (Alimentación, Transporte, Salud, Educación...) con colores e íconos |
| **2** | `CargarDatosComercio` | **100** | Comercios con NIT único, actividad, dirección y representante legal |
| **3** | `CargarDatosMedioPago` | **50** | Medios de pago de bancos colombianos asociados a usuarios |
| **4** | `CargarDatosGasto` | **200** | Gastos asociados a usuario, categoría, comercio y medio de pago aleatorios |

> 🎲 Todos los generadores usan `Random(42)` como semilla, garantizando datos **reproducibles** entre ejecuciones.

> ⚠️ Como `spring.jpa.hibernate.ddl-auto=create`, el esquema y los datos **se recrean en cada arranque** y no persisten al apagar la aplicación.

---

## 🔧 Configuración

`src/main/resources/application.properties`:

```properties
# 🌐 Nombre de la aplicación
spring.application.name=migajaApp

# 🗄️ Base de datos H2 en memoria
spring.datasource.url=jdbc:h2:mem:hormiga_gasto
spring.datasource.username=sa
spring.datasource.password=

# 🖥️ Consola H2 habilitada
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# ⚙️ JPA / Hibernate
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

> 💡 **Nota:** Con `ddl-auto=create`, el esquema se recrea en cada inicio. Los datos seed se vuelven a generar automáticamente vía `CommandLineRunner`.

---

## 🚀 Cómo Ejecutar

### 📋 Prerrequisitos

- ☕ **Java 25** o superior
- 📦 **Maven 3.x** (o usar el wrapper incluido)

### ▶️ Pasos

```bash
# 1️⃣ Clonar el repositorio
git clone <url-del-repositorio>
cd migajaApp

# 2️⃣ Compilar el proyecto
./mvnw clean install

# 3️⃣ Ejecutar la aplicación
./mvnw spring-boot:run
```

> 🪟 En Windows usa `mvnw.cmd clean install` y `mvnw.cmd spring-boot:run`.

### 🌐 Accesos

| Recurso | URL |
|---------|-----|
| 🏠 API Base | `http://localhost:8080` |
| 🖥️ Consola H2 | [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console) |
| 🗄️ JDBC URL | `jdbc:h2:mem:hormiga_gasto` |
| 👤 Usuario BD | `sa` |
| 🔑 Contraseña | *(vacía)* |

### 🧪 Probar los endpoints

Puedes probar la API con **Postman**, **Insomnia**, **Thunder Client** o `curl`:

```bash
# Listar todos los usuarios
curl http://localhost:8080/apiMigaja/v1/usuarios

# Listar todas las categorías
curl http://localhost:8080/migaja/v1/categoria

# Listar todos los gastos
curl http://localhost:8080/migaja/v1/gasto
```

---

## 👥 Equipo de Desarrollo

<div align="center">

<table>
  <tr>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Mateo+Arcila&background=6DB33F&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Mateo"/>
      <br />
      <sub><b>🧑‍💻 Mateo Arcila Patiño</b></sub>
      <br/>
      <sub>👤 Usuarios</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Luz+Zabala&background=ED8B00&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Luz"/>
      <br />
      <sub><b>👩‍💻 Luz Marycelda Zabala Gutierrez</b></sub>
      <br/>
      <sub>💳 Medio de Pago</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Emanuel+Zuluaga&background=8E44AD&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Emanuel"/>
      <br />
      <sub><b>🧑‍💻 Emanuel Zuluaga</b></sub>
      <br/>
      <sub>💸 Gasto</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Pablo+Lopera&background=0078D4&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Pablo"/>
      <br />
      <sub><b>🧑‍💻 Pablo Andres Moreno Lopera</b></sub>
      <br/>
      <sub>🏪 Comercio</sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Nicolas+Marulanda&background=C71A36&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Nicolas"/>
      <br />
      <sub><b>🧑‍💻 Nicolas Marulanda Alvarez</b></sub>
      <br/>
      <sub>🏷️ Categoría</sub>
    </td>
  </tr>
</table>

<br/>

<img src="https://img.shields.io/badge/CESDE-Proyecto%20Integrador-6DB33F?style=for-the-badge" />
<img src="https://img.shields.io/badge/Backend%20II-Semestre%20III-ED8B00?style=for-the-badge" />

</div>

---

<div align="center">

### 🐜 *"Cada migaja cuenta... ¡y cada gasto hormiga también!"* 🐜

<br/>

Hecho con ❤️ por el equipo MigajaApp — CESDE 2026

</div>
