# Proyecto de Gestión de Alumnos

Este proyecto es una aplicación de consola en Java que permite gestionar alumnos, sus materias y notas. Utiliza Maven como herramienta de construcción y gestión de dependencias.

## Características

- Crear alumnos
- Listar alumnos
- Agregar materias a los alumnos
- Agregar notas a las materias de los alumnos
- Exportar datos de los alumnos a un archivo de texto

## Requisitos

- Java 17 o superior
- Maven 3.6.3 o superior

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/cheruless/Mod4Final.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd mod4final
    ```
3. Compila el proyecto con Maven:
    ```sh
    mvn clean install
    ```

## Uso

1. Ejecuta la aplicación:
    ```sh
    mvn exec:java -Dexec.mainClass="org.colegiolatinoamericano.vistas.Menu"
    ```
2. Sigue las instrucciones en la consola para interactuar con el menú.

## Estructura del Proyecto

- `src/main/java/org/colegiolatinoamericano/modelos/`: Contiene las clases de modelo (`Alumno`, `Materia`, `MateriaEnum`).
- `src/main/java/org/colegiolatinoamericano/servicios/`: Contiene las clases de servicio (`AlumnoServicio`, `ArchivosServicio`).
- `src/main/java/org/colegiolatinoamericano/vistas/`: Contiene las clases de vista (`Menu`, `MenuTemplate`).
