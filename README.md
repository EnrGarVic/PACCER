1. Estructura General del Proyecto

El proyecto está diseñado como un juego de dos jugadores donde uno juega como un coche y el otro como un policía. Los jugadores se conectan a través de un modelo cliente-servidor, y el objetivo es que el coche evite al policía mientras el policía intenta atraparlo. El juego incluye autenticación de usuarios y un sistema de ranking para registrar las victorias de los jugadores.
2. Clases Principales y Funcionalidades
MainClass

    Es la clase principal que inicia el juego.
    Crea una instancia del objeto Game.

Game

    Es la clase principal del juego que implementa Runnable para manejar el bucle del juego.
    Administra las ventanas del juego, el menú principal, la selección de jugadores y el panel del juego.
    Contiene métodos para iniciar el bucle del juego, actualizar la lógica del juego, renderizar los gráficos y manejar el temporizador.
    Se encarga de iniciar y manejar las conexiones cliente-servidor y de registrar los ganadores en la base de datos.

GameWindow

    Maneja la ventana del juego utilizando JFrame.
    Permite cambiar entre diferentes paneles (menú, selección de jugadores, juego).

MenuPanel

    Panel que muestra el menú principal con opciones de login y registro de usuario.
    Contiene botones para iniciar sesión y registrarse.

LoginPanel

    Panel que maneja la autenticación de usuarios.
    Permite a los usuarios ingresar su nombre de usuario y contraseña para iniciar sesión.

SignUpPanel

    Panel que maneja el registro de nuevos usuarios.
    Permite a los usuarios ingresar un nombre de usuario y una contraseña para registrarse.

PlayerSelectionPanel

    Panel que permite a los usuarios seleccionar su rol (coche o policía).
    Inicia el servidor si el usuario selecciona ser el coche, o el cliente si selecciona ser el policía.

GamePanel

    Panel donde se renderiza el juego.
    Contiene métodos para pintar los componentes del juego (jugadores, nivel, temporizador).

3. Clases de Jugadores
Coche

    Clase abstracta que define una entidad genérica con una hitbox.

Jugador1 y Jugador2

    Clases que heredan de Coche y representan al coche y al policía respectivamente.
    Definen la lógica específica de cada jugador, incluyendo la actualización de posición y el renderizado.
    Manejan la dirección de movimiento y la velocidad de los jugadores.

4. Clases de Niveles
ManejoDeNiveles

    Maneja los niveles del juego.
    Carga los datos del nivel y los sprites.
    Dibuja el nivel en el panel del juego.

Nivel

    Clase que define un nivel específico en el juego.
    Almacena los datos del nivel y proporciona métodos para acceder a ellos.

5. Multijugador
Servidor

    Inicia el servidor del juego.
    Acepta conexiones de clientes y maneja la comunicación entre el servidor y el cliente.
    Envía y recibe datos de los jugadores (posiciones, direcciones).

Cliente

    Se conecta al servidor del juego.
    Envía y recibe datos del servidor (posiciones, direcciones).

6. Base de Datos
UserLogin y UserRegistration

    Manejan la autenticación y el registro de usuarios.
    Conectan a la base de datos para verificar las credenciales de los usuarios y registrar nuevos usuarios.

GameResult

    Maneja la inserción y consulta de resultados de juegos en la base de datos.
    Inserta el nombre del ganador en la base de datos.
    Consulta los rankings de los jugadores basados en el número de victorias.

7. Utils
HelpMethods

    Contiene métodos de ayuda para verificar si un jugador puede moverse a una nueva posición basada en los datos del nivel.

LoadSave

    Maneja la carga de recursos (imágenes, datos del nivel).
    Proporciona métodos para cargar sprites y datos de niveles desde archivos.

Flujo del Juego

    Inicio del Juego:
        El juego comienza con el menú principal (MenuPanel).
        Los jugadores pueden iniciar sesión o registrarse.

    Selección de Jugador:
        Una vez autenticados, los jugadores seleccionan su rol en el PlayerSelectionPanel.

    Conexión Cliente-Servidor:
        El servidor se inicia si el jugador selecciona ser el coche.
        El cliente se conecta al servidor si el jugador selecciona ser el policía.

    Bucle del Juego:
        El bucle del juego se ejecuta en la clase Game, actualizando y renderizando el juego.
        Las posiciones de los jugadores se actualizan y se envían entre el cliente y el servidor.

    Registro de Resultados:
        Cuando el juego termina, el resultado se registra en la base de datos utilizando GameResult.
        Los resultados se pueden consultar y mostrar en el ranking.

