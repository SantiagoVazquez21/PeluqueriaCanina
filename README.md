# Peluquería Canina

Aplicación de escritorio en Java Swing para registrar las mascotas que atiende una peluquería canina, junto con los datos de su dueño.
Permite cargar, ver, modificar y eliminar mascotas, guardando todo en MySQL con JPA (EclipseLink).

## Funcionalidades

- **Cargar datos:** alta de una mascota y su dueño, con validación de cada campo (campos obligatorios, solo letras o solo números según el campo y celular de 10 dígitos).
- **Ver datos:** tabla con todas las mascotas registradas.
- **Modificar:** edición de los datos de la mascota y de su dueño.
- **Eliminar:** baja de una mascota desde la tabla.

## Tecnologías

- Java Swing (formularios diseñados con NetBeans)
- JPA 2.2 con EclipseLink 2.7
- MySQL (conector `mysql-connector-j`)
- Maven

## Estructura

| Paquete | Contenido |
|---|---|
| `igu` | Pantallas: `Principal`, `CargaDatos`, `VerDatos`, `ModificarDatos` |
| `logica` | Entidades `Mascota` y `Duenio` (relación 1 a 1) y `ControladorLogica` |
| `persistencia` | Controladores JPA de cada entidad y `ControladorPersistencia` |

## Requisitos

- JDK 26 o superior
- Apache NetBeans (o Maven desde la terminal)
- XAMPP con MySQL

## Cómo ejecutarlo

1. Iniciar MySQL desde el panel de XAMPP.
2. En phpMyAdmin, crear una base vacía llamada `peluqueria_canina`.
3. Abrir el proyecto en NetBeans y ejecutarlo con **Run** (o `mvn compile exec:java` desde la terminal).

Las tablas se crean solas la primera vez que se ejecuta. La conexión usa el usuario `root` sin contraseña, que es la configuración por defecto de XAMPP. Si tu MySQL usa otros datos, cambialos en `src/main/resources/META-INF/persistence.xml`.
