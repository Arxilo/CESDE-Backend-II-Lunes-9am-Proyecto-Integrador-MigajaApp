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
- [🔧 Configuración](#-configuración)
- [🚀 Cómo Ejecutar](#-cómo-ejecutar)
- [👥 Equipo de Desarrollo](#-equipo-de-desarrollo)

---

## 🐜 Descripción del Proyecto

**MigajaApp** es una API REST desarrollada con **Spring Boot** como proyecto integrador de la materia **Backend II** en **CESDE**. Su objetivo principal es brindar una herramienta para el registro y análisis de **gastos hormiga** — esos pequeños gastos cotidianos (café, snacks, suscripciones, transporte, etc.) que individualmente parecen insignificantes, pero que en conjunto impactan significativamente las finanzas personales.

### 🎯 Objetivos
| | Objetivo |
|---|----------|
| 📊 | Registrar gastos diarios con detalle completo |
| 🏷️ | Categorizar gastos por tipo, prioridad y comercio |
| 💳 | Controlar los medios de pago utilizados |
| 🏪 | Gestionar información de comercios frecuentes |
| 👤 | Administrar perfiles de usuarios |
| 📈 | Medir el impacto financiero de los gastos hormiga |

---

## 🏗️ Arquitectura y Estructura

```
🐜 migajaApp/
│
├── 📂 .mvn/wrapper/                    # Maven Wrapper
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/cesde/migaja/migajaApp/
│   │   │   ├── 🚀 MigajaAppApplication.java      # Clase principal
│   │   │   └── 📂 Models/
│   │   │       ├── 🏷️ categoria.java              # Entidad Categoría
│   │   │       ├── 🏪 Comercio.java                # Entidad Comercio
│   │   │       ├── 💸 Gasto.java                   # Entidad Gasto
│   │   │       ├── 💳 MedioPago.java               # Entidad Medio de Pago
│   │   │       └── 👤 Usuario.java                  # Entidad Usuario
│   │   └── 📂 resources/
│   │       └── ⚙️ application.properties           # Configuración
│   └── 📂 test/
│       └── 🧪 MigajaAppApplicationTests.java      # Tests
│
├── 📄 pom.xml                           # Dependencias Maven
├── 📄 mvnw / mvnw.cmd                   # Maven Wrapper scripts
└── 📄 README.md                         # Este archivo
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

</div>

### 📦 Dependencias Principales

```xml
🟢 spring-boot-starter-data-jpa      → Persistencia con JPA/Hibernate
🟢 spring-boot-starter-webmvc        → API REST con Spring MVC
🟡 spring-boot-h2console             → Consola web para la base de datos H2
🔵 spring-boot-devtools              → Herramientas de desarrollo (hot reload)
🧪 spring-boot-starter-data-jpa-test → Testing de capa de datos
🧪 spring-boot-starter-webmvc-test   → Testing de controladores web
```

---

## 🗃️ Modelos de Datos

### 💸 Gasto — `gastos`
> *Entidad principal que representa cada gasto hormiga registrado.*

| 🏷️ Campo | 📋 Tipo | 🔒 Restricciones |
|-----------|---------|-------------------|
| `id` | `Integer` | 🔑 PK, Auto-generado |
| `descripcion` | `String` | ⚠️ NOT NULL, máx 150 chars |
| `fecha` | `LocalDate` | ⚠️ NOT NULL |
| `monto` | `Double` | ⚠️ NOT NULL |
| `imagen` | `String` | máx 255 chars |
| `moneda` | `String` | ⚠️ NOT NULL, máx 20 chars |
| `metodoPago` | `String` | máx 50 chars |
| `lugar` | `String` | máx 150 chars |
| `esRecurrente` | `Boolean` | ⚠️ NOT NULL |
| `tipoGasto` | `String` | ⚠️ NOT NULL, máx 50 chars |
| `impactoFinanciero` | `Integer` | ⚠️ NOT NULL |
| `activo` | `Boolean` | ⚠️ NOT NULL |
| `observaciones` | `String` | máx 300 chars |

---

### 👤 Usuario — `usuarios`
> *Usuarios del sistema que registran sus gastos.*

| 🏷️ Campo | 📋 Tipo |
|-----------|---------|
| `id` | `Integer` 🔑 |
| `nombre` | `String` |
| `tipoDocumento` | `String` |
| `numeroDocumento` | `String` |
| `edad` | `Integer` |
| `apellidos` | `String` |
| `email` | `String` |
| `telefono` | `String` |
| `direccion` | `String` |
| `rol` | `String` |

---

### 🏷️ Categoría — `categorias`
> *Clasificación temática para organizar los gastos.*

| 🏷️ Campo | 📋 Tipo |
|-----------|---------|
| `id` | `Integer` 🔑 |
| `nombre` | `String` |
| `fechaCreacion` | `String` |
| `responsable` | `String` |
| `justificacion` | `String` |
| `descripcion` | `String` |
| `prioridad` | `Integer` |
| `color` | `String` |
| `icono` | `String` |
| `estado` | `Boolean` |

---

### 💳 Medio de Pago — `medios_pago`
> *Métodos de pago disponibles (tarjetas, efectivo, transferencias, etc.)*

| 🏷️ Campo | 📋 Tipo |
|-----------|---------|
| `id` | `Integer` 🔑 |
| `nombre` | `String` |
| `franquicia` | `String` |
| `estado` | `Boolean` |

---

### 🏪 Comercio — `comercios`
> *Establecimientos donde se realizan los gastos.*

| 🏷️ Campo | 📋 Tipo |
|-----------|---------|
| `id` | `Integer` 🔑 |
| `nit` | `Integer` |
| `nombre` | `String` |
| `correo` | `String` |
| `direccion` | `String` |
| `telefono` | `String` |
| `sitioWeb` | `String` |
| `actividad` | `String` |
| `representanteLegal` | `String` |

---

### 🔗 Diagrama de Relaciones (propuesto)

```
┌──────────┐       ┌──────────┐
│ Usuario  │──┐    │Categoría │
└──────────┘  │    └────┬─────┘
              │         │
              ▼         ▼
         ┌─────────────────┐
         │      GASTO      │
         └─────────────────┘
              ▲         ▲
              │         │
┌──────────┐  │    ┌────┴─────┐
│MedioPago │──┘    │ Comercio │
└──────────┘       └──────────┘
```

---

## 🔧 Configuración

La aplicación utiliza una base de datos **H2 en memoria** con la siguiente configuración:

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

> 💡 **Nota:** Con `ddl-auto=create`, el esquema se recrea en cada inicio. Los datos no persisten entre reinicios.

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

### 🌐 Accesos

| Recurso | URL |
|---------|-----|
| 🖥️ Consola H2 | [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console) |
| 🗄️ JDBC URL | `jdbc:h2:mem:hormiga_gasto` |
| 👤 Usuario BD | `sa` |
| 🔑 Contraseña | *(vacía)* |

---

## 👥 Equipo de Desarrollo

<div align="center">

<table>
  <tr>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Mateo+Arcila&background=6DB33F&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Mateo"/>
      <br />
      <sub><b>🧑‍💻 Mateo Arcila Patiño</b></sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Luz+Zabala&background=ED8B00&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Luz"/>
      <br />
      <sub><b>👩‍💻 Luz Marycelda Zabala Gutierrez</b></sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Pablo+Moreno&background=0078D4&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Pablo"/>
      <br />
      <sub><b>🧑‍💻 Pablo Andres Moreno Lopera</b></sub>
    </td>
    <td align="center">
      <img src="https://ui-avatars.com/api/?name=Nicolas+Marulanda&background=C71A36&color=fff&size=100&rounded=true&bold=true" width="100px;" alt="Nicolas"/>
      <br />
      <sub><b>🧑‍💻 Nicolas Marulanda Alvarez</b></sub>
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
