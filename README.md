📘 taskSpringJava

API RESTful desarrollada con Spring Boot para la gestión de tareas y notas de usuarios. Incluye autenticación mediante JWT y operaciones CRUD para usuarios y notas.

🚀 Tecnologías utilizadas
•	Java 17
•	Spring Boot
•	Spring Security
•	JWT (JSON Web Tokens)
•	Gradle
•	Base de datos relacional (por ejemplo, MySQL o PostgreSQL)

📂 Estructura del proyecto

⚙️ Configuración y ejecución
1.	Clonar el repositorio:


git clone https://github.com/OscarVarelaGallardo/taskSpringJava.git
cd taskSpringJava

	2.	Configurar la base de datos:
    Asegúrate de tener una base de datos configurada y actualiza las credenciales en src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña


    3.	Construir el proyecto:
./gradlew build

    4.	Ejecutar la aplicación:
./gradlew bootRun

La aplicación estará disponible en http://localhost:8080.

    🔐 Autenticación

La API utiliza JWT para la autenticación. Los endpoints de registro y login están disponibles sin autenticación:
•	POST /auth/register
•	POST /auth/login

Para acceder a los demás endpoints, es necesario incluir el token JWT en el encabezado de las solicitudes:

Authorization: Bearer <tu_token>

    📌 Endpoints principales
    •	POST /auth/register - Registrar un nuevo usuario.
    •	POST /auth/login - Autenticar usuario y obtener token JWT.
    •	GET /notes/{id} - Obtener notas del usuario con ID especificado.
    •	POST /notes/{id} - Crear una nueva nota para el usuario con ID especificado.