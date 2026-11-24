BIODIVERCR

Libro interactivo en Java sobre la biodiversidad del Pacífico costarricense, para niños de 5.º y 6.º.

Autor: Sofía Marín


COMO EJECUTAR

1. Abrir el proyecto en NetBeans.
2. Ejecutar la clase main.Principal.


COMO SE USA

1. En la portada, presionar Iniciar lectura.
2. Leer las 3 páginas con Anterior y Siguiente.
3. En la última página, presionar Responder y contestar las 3 preguntas.
4. Ver los puntos obtenidos. Se puede intentar hasta 3 veces.
5. Resultados muestra el historial de intentos, Menú principal vuelve a la portada y Salir cierra el programa.


ESTRUCTURA (MVC)

- modelo: Pagina (abstracta), PaginaInformativa, PaginaActividad, Pregunta y Libro.
- vista: VistaLibro, la ventana hecha con el GUI Builder.
- controlador: Controlador, que atiende los botones y conecta la vista con el modelo.
- main: Principal, que abre el programa.


LO QUE SE APLICO

- Clase abstracta, herencia y polimorfismo: PaginaInformativa y PaginaActividad heredan de Pagina y cada una muestra su contenido a su manera.
- ArrayList: Libro guarda las páginas en un ArrayList de Pagina.
- Arreglo: respuestasCorrectas guarda la opción correcta de cada pregunta.
- Matriz: registro guarda las respuestas de cada intento (filas) por pregunta (columnas).
- Excepciones: el modelo avisa cuando se pide una página que no existe, un intento fuera de rango o una respuesta inválida, y el controlador las atrapa con try/catch para mostrar un mensaje amable.

